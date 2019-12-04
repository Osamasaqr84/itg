package com.noname.task.model.usecases

import android.content.Context
import android.net.ConnectivityManager
import android.widget.ImageView
import android.widget.Toast
import com.noname.task.R
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import com.squareup.picasso.Picasso
import android.content.Intent
import android.net.Uri


fun loudImage(context: Context?, imag: ImageView, url: String?) {

    Picasso.with(context)
        .load(url)
        .placeholder(R.drawable.load)
        .error(R.drawable.noimg)
        .into(imag);
}

fun loadUrl(context: Context,uri:String)
{
    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
    context.startActivity(browserIntent)
}

fun showToastBasedOnThrowable(context: Context?,throwable: Throwable?)
{
    var messege = "error occure"
    when (throwable) {
        is IOException -> messege="Something Went Wrong"
        is UnknownHostException ->messege= "No internet connectivity"
        is SocketTimeoutException ->messege= "Slow Internet connectivity"
        else -> throwable?.message
    }

    Toast.makeText(context,messege,Toast.LENGTH_SHORT).show()
}


fun getDate(datesample: String?): String {
    if (datesample!=null&&datesample.length>1)
    return  datesample.substring(0,10)

//    val sdf = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssz")
//    try {
//        val dateObj = sdf.parse(datesample)
//        val timestamp = dateObj.time.toString()//  //Example -> in ms
//        val formatter = SimpleDateFormat("dd/MM/yyyy")
//        return formatter.format(Date(Long.parseLong(timestamp)))
//    } catch (e: ParseException) {
//        e.printStackTrace()
//    }
    return null.toString()
}

val Context.isConnected: Boolean
    get() {
        return (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
                .activeNetworkInfo?.isConnected == true
    }
