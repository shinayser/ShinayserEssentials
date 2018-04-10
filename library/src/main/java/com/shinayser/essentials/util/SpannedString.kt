package com.shinayser.essentials.util

import android.support.annotation.ColorInt
import android.text.SpannableStringBuilder
import androidx.core.text.*

inline fun SpannableStringBuilder.boldColor(@ColorInt color: Int, builderAction: SpannableStringBuilder.() -> Unit) = apply {
	bold {
		color(color, builderAction)
	}
}

inline fun SpannableStringBuilder.boldScale(proportion: Float, builderAction: SpannableStringBuilder.() -> Unit) = apply {
	bold {
		scale(proportion, builderAction)
	}
}

inline fun SpannableStringBuilder.italicColor(@ColorInt color: Int, builderAction: SpannableStringBuilder.() -> Unit) = apply {
	italic {
		color(color, builderAction)
	}
}

inline fun SpannableStringBuilder.italicScale(proportion: Float, builderAction: SpannableStringBuilder.() -> Unit) = apply {
	italic {
		scale(proportion, builderAction)
	}
}

inline fun SpannableStringBuilder.underlineColor(@ColorInt color: Int, builderAction: SpannableStringBuilder.() -> Unit) = apply {
	underline {
		color(color, builderAction)
	}
}

inline fun SpannableStringBuilder.underlineScale(proportion: Float, builderAction: SpannableStringBuilder.() -> Unit) = apply {
	underline {
		scale(proportion, builderAction)
	}
}

inline fun SpannableStringBuilder.scaleColor(proportion: Float, @ColorInt color: Int, builderAction: SpannableStringBuilder.() -> Unit) = apply {
	scale(proportion) {
		color(color, builderAction)
	}
}