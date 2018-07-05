package com.shinayser.essentials.util

import java.net.URLEncoder

fun String.urlEncode(encoding: String = "utf-8"): String? =
		try {
			URLEncoder.encode(this, encoding)
		} catch (e: Exception) {
			null
		}