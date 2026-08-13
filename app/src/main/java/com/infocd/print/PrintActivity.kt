package com.infocd.print

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import org.json.JSONObject
import java.net.URLDecoder

class PrintActivity : Activity() {

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(savedInstanceState)

        try {

            procesar()

        } catch (e: Exception) {

            Toast.makeText(
                this,
                e.message,
                Toast.LENGTH_LONG
            ).show()

        }

        finish()

    }

    private fun procesar() {

        val uri: Uri =
            intent.data ?: return

        val rawData =
            uri.getQueryParameter(
                "data"
            ) ?: return

        val json =
            URLDecoder.decode(
                rawData,
                "UTF-8"
            )

        val obj =
            JSONObject(json)

        val ip =
            obj.getString("ip")

        val zpl =
            obj.getString("zpl")

        Thread {

            ZebraPrinter.print(
                ip,
                zpl
            )

        }.start()

    }

}
