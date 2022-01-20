package com.itcube.chatcube

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.itcube.chatcube.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private lateinit var launcher: ActivityResultLauncher<Intent>
    private lateinit var auth:FirebaseAuth
    private lateinit var binding: ActivityAuthBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth=Firebase.auth
        launcher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        val task=GoogleSignIn.getSignedInAccountFromIntent(it.data)
            try {
                val account=task.getResult(ApiException::class.java)
                if (account != null){
                    firebaseAuth(account.idToken!!)
                }
        } catch (e:ApiException){


            }        }
        binding.button2.setOnClickListener {
            signInWithGoogle()
        }
        checkAuth()
    }
    private fun getClient(): GoogleSignInClient{
        val gso = GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        return GoogleSignIn.getClient(this,gso)
    }

    private fun signInWithGoogle(){
        val signInClient=getClient()
        launcher.launch(signInClient.signInIntent)
    }
    private fun firebaseAuth(idToken:String){
        val credencial=GoogleAuthProvider.getCredential(idToken,null)
        auth.signInWithCredential(credencial).addOnCompleteListener {
            if(it.isSuccessful){
                Log.d("MyLog","Google signIN done")
                checkAuth()
            } else {
                Log.d("MyLog","Google signIn error")
            }
        }
    }

    private fun checkAuth(){
        if (auth.currentUser != null){
            val i=Intent(this,MainActivity::class.java)
            startActivity(i)
        }
    }
}