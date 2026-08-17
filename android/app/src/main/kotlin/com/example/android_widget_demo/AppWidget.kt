package com.example.android_widget_demo


import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

class MyAppWidget : AppWidgetProvider (){
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ){
        for (appWidgetId in appWidgetIds) {

            // We create the widget UI
            val views = RemoteViews(
                context.packageName,
                R.layout.widget_layout
            )

            // We tell the button what to do
            val intent = Intent(
                context,
                MainActivity::class.java
            )

            // creates an action Android can execute later
            val pendingIntent = PendingIntent.getActivity(
                context,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or
                        PendingIntent.FLAG_IMMUTABLE
            )

            views.setOnClickPendingIntent(
                R.id.widget_button,
                pendingIntent
            )

            // We give the completed widget to Android
            appWidgetManager.updateAppWidget(
                appWidgetId,
                views
            )
        }
    }
}
