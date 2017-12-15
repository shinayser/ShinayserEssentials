# ShinayserEssentials
This library contains a set of utility classes and extension methods (Kotlin) to use within any Android project.

*You can use it if you are using Java as your project language, but it is not recommended.*

# Get it

Add to your Gradle file:

    repositories {
      maven {
         url "https://jitpack.io"
      }
    }       


Then add this to your "depedencies":
   
    implementation 'com.github.shinayser:ShinayserEssentials:1.4.0'

# YoYo library DSL

    /*The duration parameter is optional, default is 300.*/
    anyView.yoyoAnimation(Techniques.FadeIn, duration = 400) {
                        atEnd {
                            //Do code at End
                        }
                        
                        atStart {
                            //Do code at start
                        }
                        
                        atCancel{
                            //Do code when cancel
                        }
                        
                        atRepeat{
                            //Do code when repeat
                        }
                    }
