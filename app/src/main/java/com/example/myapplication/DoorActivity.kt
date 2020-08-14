package com.example.myapplication

import android.graphics.Bitmap
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.MediaStore.Images.Media.getBitmap
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.lifecycleScope
import coil.Coil
import coil.request.GetRequest
import com.example.myapplication.data.AccessDoor
import com.example.myapplication.web.WebClient
import kotlinx.android.synthetic.main.activity_door.*
import kotlinx.coroutines.launch

class DoorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_door)
        val photo = intent.getStringExtra("photo")
        lifecycleScope.launch { image.setImageBitmap(photo?.let { getBitmap(url = it) }) }
        door.setOnClickListener {
            lifecycleScope.launch { WebClient.setaccesscall(AccessDoor(true)) }
        }
    }


    // Скачиваем картинку по URL
    suspend fun getBitmap(url: String): Bitmap? {
        val request = GetRequest.Builder(this)
            .data(url)
            .build()
        val result = Coil.imageLoader(this).execute(request).drawable
        return result?.toBitmap(result.intrinsicWidth, result.intrinsicHeight)
    }
}