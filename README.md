# wck
Word Counter with Kotlin

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
