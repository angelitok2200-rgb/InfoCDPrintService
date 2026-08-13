package com.infocd.print

import java.net.Socket

object ZebraPrinter {

    fun print(
        ip: String,
        zpl: String
    ) {

        val socket =
            Socket(
                ip,
                9100
            )

        socket
            .getOutputStream()
            .write(
                zpl.toByteArray()
            )

        socket
            .getOutputStream()
            .flush()

        socket.close()

    }

}
