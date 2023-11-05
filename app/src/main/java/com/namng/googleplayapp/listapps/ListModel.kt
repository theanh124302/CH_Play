package com.namng.googleplayapp.listapps

import com.namng.googleplayapp.apps.AppAdapter

class ListModel(val name: String, val listapp: AppAdapter) {
    var selected: Boolean = false
}