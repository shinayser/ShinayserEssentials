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
   
    implementation 'com.github.shinayser:ShinayserEssentials:1.9.0'



# Simplified Conditions DSL

    //For api requirements use onLollipop, onNougat, onOreo...
    
    
    onLollipop {    
      //If lollipop...    
    } otherwise {
      //If not lollipop...       
    }
           
    ifNotNull(1, 2, 3) {
       //if All not null
    } otherwise {
       //Or esle...
    }
        
    
    ifAllNull(1, 2, null) {
        //If all params are null...
    } otherwise {
        //Or else...
    }
    

# Json creation DSL

    val jsonObject = jsonOf {
            "Integer" oto 3
            "Double" oto 3.5
            "Float" oto 3.5f
            "Array" oto jsonArrayOf(1, 2, "Just A string")
            "Another object" oto jsonOf {
                "A long value" oto 3L
            }
        }


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
