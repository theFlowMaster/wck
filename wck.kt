
/*  
    WCK : word counter kotlin
    writer : Mersad Akbari
    contact {
        GitHub : GitHub.Com/MersadAbari
        Gmail : Mersad23Akbari@Gmail.Com
    }
    Special thanks to Github.com/Sina-Carbon 
*/


// import library which you can use files with that
import java.io.File

// assign help function which prints the help
fun help(){
    print("""

USAGE :
    COMPILE :
        kotlinc wck.kt -include-runtime -d wck.jar
    RUN :
        java -jar wck.jar [FLAGS] <INPUT>
FLAGS :
    -h,--help  -> prints help
    -l         -> prints newline counts
    -w         -> prints word counts
    -wl,-lw    -> prints word and newline counts

ARGS:
    <INPUT> set the input file to use

EXAMPLE:
    java -jar wck.jar -wl wck.kt
    """)
}

// assign lineReader function which gets a file for input and will give us the file lines
fun lineReader(targetFile:String){
    // assign linecounter variable which holds the lines number
    var linecounter = 1
    // check every character
    for (i in File(targetFile).readText()){
        // if the character was a newline , add 1 to the linecounter variable
        if(i.toString() == "\n"){
            linecounter += 1
        }
    }
    // at the end print the linecounter variable
    println ("lines : $linecounter")
}

fun wordReader(targetFile:String){
    // assign wordcounter variable which holds the wordes number
    var wordcounter = 1
    // assign wordholder variable which helps us to count words
    var wordholder = ""
    // check every character
    for (i in File(targetFile).readText().trim()){
        // if the character was a space or a newline
        if(i.toString() == " " || i.toString() == "\n"){
            // if wordholder was not empty
            if(wordholder.count() >= 1){
                // add 1 to wordcounter and clear the wordholder
                wordcounter += 1
                wordholder = ""
            }
        // if was not space or newline
        }else{
            // add that char to wordholder variable
            wordholder += i
        }
    }// at the end print how many word we have
    println ("words : $wordcounter")
}
// assign run function which gets arguments for input and will run the program
fun run(args:Array<String>){
    // we write codes in a try block for error handling
    try {
        // if user inputed nothing for args we show him/her the help
        if(args.size == 0){
            print("\n ERROR : give me something :(")
            help()
        // if user inpuuted just 1 argument 
        }else if (args.size == 1){
            if (args[0].startsWith('-')){
                print("\n ERROR : please tell me the file name")
                help()
            }else if(args[0] == "-h" || args[0] == "--help"){
                help()
            }else{
                print("\n ERROR : tell me what do you want? , line?word?both?")
                help()
            }
        // if user inputed 2 argument
        }else if (args.size == 2){
            //Errors :
            if(args[0].startsWith('-') and args[1].startsWith('-')){
                print("\n ERROR : please tell me the file name")
                help()
            }else if((args[0][0] != '-') and (args[1][0] != '-')) {
                print("\n ERROR : tell me what do you want? , line?word?both?")
                help()
            // program :
            }else{
                if(args[0]=="-l"){
                    lineReader(args[1])
                }
                else if (args[0]=="-w"){
                    wordReader(args[1])
                }
                else if (args[0]=="-lw"){
                    lineReader(args[1])
                    wordReader(args[1])
                }
                else if (args[0]=="-wl"){
                    wordReader(args[1])
                    lineReader(args[1])
                }
                else{
                    print("\n ERROR : Bad arguments ")
                }
            }
        // if user inputed 3 arguments
        }else if (args.size == 3){
            if(args[0]=="-l" && args[1]=="-w"){
                lineReader(args[2])
                wordReader(args[2])
            }
            else if(args[0]=="-w" && args[1]=="-l"){
                wordReader(args[2])
                lineReader(args[2])
            }
            else{
                print("\n ERROR :Bad arguments")
                help()
            }
        }else{
            print("\n ERROR : input is more than 3")
            help()
        }
    // if file was corrupt or ...
    }catch(e:Exception){
        print(e)
    }
}

fun main(args:Array<String>){
    run(args)
}
// The End ...