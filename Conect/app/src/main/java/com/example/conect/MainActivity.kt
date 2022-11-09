package com.example.conect

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbDeviceConnection
import android.hardware.usb.UsbManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.conect.databinding.ActivityMainBinding
import com.felhr.usbserial.UsbSerialDevice
import com.felhr.usbserial.UsbSerialInterface


class MainActivity : AppCompatActivity() {

    lateinit var m_usbManager: UsbManager
    var m_device: UsbDevice? = null
    var m_serial: UsbSerialDevice? = null
    var m_connection: UsbDeviceConnection? = null
    val ACTION_USB_PERMISSION = "permission"
    lateinit var b:ActivityMainBinding
    lateinit var red:SeekBar
    lateinit var green:SeekBar
    lateinit var blue:SeekBar
    lateinit var drive:SeekBar
    lateinit var revers:SeekBar
    lateinit var drive_on:Switch
    lateinit var progress_d:TextView
    lateinit var color:Button
    lateinit var sos:Button
    lateinit var sos_off:Button

    var redValue: Int=0
    var greenValue: Int=0
    var blueValue: Int=0
    var count: Int=0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b=ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        m_usbManager = getSystemService(Context.USB_SERVICE) as UsbManager

        val filter = IntentFilter()
        filter.addAction(ACTION_USB_PERMISSION)
        filter.addAction(UsbManager.ACTION_USB_ACCESSORY_ATTACHED)
        filter.addAction(UsbManager.ACTION_USB_DEVICE_ATTACHED)
        registerReceiver(broadcastReceiver, filter)

        val disconnect:Button=findViewById(R.id.disconnect)
        val connect:Button=findViewById(R.id.connect)
        red=findViewById(R.id.red)
        green=findViewById(R.id.green)
        blue=findViewById(R.id.blue)
        color=findViewById(R.id.color)
        sos=findViewById(R.id.sos)
        sos_off=findViewById(R.id.off_sos)
        drive=findViewById(R.id.drive)
        revers=findViewById(R.id.revers)
        drive_on=findViewById(R.id.drive_on)
        progress_d=findViewById(R.id.progress)
        drive.isEnabled=false
        revers.isEnabled=false



        disconnect.setOnClickListener { disconnect() }
        connect.setOnClickListener { startUsbConnecting() }
        red.setOnSeekBarChangeListener(seekBarChangeListener)
        green.setOnSeekBarChangeListener(seekBarChangeListener)
        blue.setOnSeekBarChangeListener(seekBarChangeListener)
        drive_on.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                startUsbConnecting()
                drive.isEnabled=true
                revers.isEnabled=true
                drive.setOnSeekBarChangeListener(seekBarDrave)
                revers.setOnSeekBarChangeListener(seekBarRevers)



            }else{
                progress_d.setText("0")
                drive.progress=0
                drive.isEnabled=false
                revers.isEnabled=false
                startUsbConnecting()
                sendData("3")
            }
        }


        color.setOnClickListener {
            startUsbConnecting()
            sendData("0") }
        sos.setOnClickListener { startUsbConnecting()
            sendData("04") }
        sos_off.setOnClickListener { startUsbConnecting()
            sendData("05") }

    }

    private fun startUsbConnecting() {
        val usbDevices: HashMap<String, UsbDevice>? = m_usbManager.deviceList
        if (!usbDevices?.isEmpty()!!) {
            var keep = true
            usbDevices.forEach{ entry ->
                m_device = entry.value
                val deviceVendorId: Int? = m_device?.vendorId
                Log.i("serial", "vendorId: "+deviceVendorId)
                if (deviceVendorId==0x2341) {
                    val intent: PendingIntent = PendingIntent.getBroadcast(this, 0, Intent(ACTION_USB_PERMISSION), 0)
                    m_usbManager.requestPermission(m_device, intent)
                    keep = false
                    Log.i("serial", "connection successful")
                    Toast.makeText(this,"connection successful",Toast.LENGTH_SHORT).show()
                } else {
                    m_connection = null
                    m_device = null
                    Log.i("serial", "unable to connect")
                    Toast.makeText(this,"unable to connect",Toast.LENGTH_SHORT).show()
                }
                if (!keep) {
                    return
                }
            }
        } else {
            Log.i("serial", "no usb device connected")
            Toast.makeText(this,"no usb device connected",Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendData(input: String) {
        if (input=="0") {
           val pos= listOf<Byte>(0x0A,3, 252.toByte(),0,redValue.toByte(),greenValue.toByte(),blueValue.toByte())
            m_serial?.write(pos.toByteArray())
        }
        if (input=="1"){
            val pos1= listOf<Byte>(0x0A,1, 254.toByte(),1,count.toByte())
            m_serial?.write(pos1.toByteArray())
        }
        if (input=="2"){
            count=Math.abs(count)
            val pos2= listOf<Byte>(0x0A,1, 254.toByte(),2,count.toByte())
            m_serial?.write(pos2.toByteArray())
        }
        if (input=="3"){
            val pos3= listOf<Byte>(0x0A,0,255.toByte(),3)
            m_serial?.write(pos3.toByteArray())
        }
        if (input=="04"){
            val pos4= listOf<Byte>(0x0A,0, 255.toByte(),4)
            m_serial?.write(pos4.toByteArray())

        }
        if (input=="05"){
            val pos5= listOf<Byte>(0x0A,0, 255.toByte(),5)
            m_serial?.write(pos5.toByteArray())
        }
    }

    private fun disconnect() {
        m_serial?.close()
    }

    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action!! == ACTION_USB_PERMISSION) {
                val granted: Boolean = intent.extras!!.getBoolean(UsbManager.EXTRA_PERMISSION_GRANTED)
                if (granted) {
                    m_connection = m_usbManager.openDevice(m_device)
                    m_serial = UsbSerialDevice.createUsbSerialDevice(m_device, m_connection)
                    if (m_serial != null) {
                        if (m_serial!!.open()) {
                            m_serial!!.setBaudRate(115200)
                            m_serial!!.setDataBits(UsbSerialInterface.DATA_BITS_8)
                            m_serial!!.setStopBits(UsbSerialInterface.STOP_BITS_1)
                            m_serial!!.setParity(UsbSerialInterface.PARITY_NONE)
                            m_serial!!.setFlowControl(UsbSerialInterface.FLOW_CONTROL_OFF)
                        } else {
                            Log.i("Serial", "port not open")
                        }
                    } else {
                        Log.i("Serial", "port is null")
                    }
                } else {
                    Log.i("Serial","permission not granted")
                }
            } else if (intent.action == UsbManager.ACTION_USB_DEVICE_ATTACHED) {
                startUsbConnecting()
            } else if (intent.action == UsbManager.ACTION_USB_DEVICE_DETACHED) {
                disconnect()
            }
        }
    }

    private val seekBarChangeListener: OnSeekBarChangeListener = object : OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
            updateBackground()
        }
        override fun onStartTrackingTouch(seekBar: SeekBar) {}
        override fun onStopTrackingTouch(seekBar: SeekBar) {}
    }
    private fun updateBackground() {

        redValue = red.getProgress()
        greenValue = green.getProgress()
        blueValue = blue.getProgress()
        // меняем фон через формат RGB
        color.setBackgroundColor(-0x1000000 + redValue * 0x10000 + greenValue * 0x100 + blueValue)
    }

    private val seekBarDrave: OnSeekBarChangeListener = object : OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
           count=progress
            progress_d.text=progress.toString()
        }
        override fun onStartTrackingTouch(seekBar: SeekBar) {}
        override fun onStopTrackingTouch(seekBar: SeekBar) {
                startUsbConnecting()
                sendData("1")
        }
    }
    private val seekBarRevers: OnSeekBarChangeListener = object : OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
            count=progress
            progress_d.text=progress.toString()
        }
        override fun onStartTrackingTouch(seekBar: SeekBar) {}
        override fun onStopTrackingTouch(seekBar: SeekBar) {
                startUsbConnecting()
                sendData("2")
        }
    }

}
