public enum TextColour {
    //ANSI Colours
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    CYAN("\u001B[36m"),
    WARNING("\u001B[31m"),
    RESET("\u001B[0m"); //white
    final String col;
    TextColour(String col){
        this.col = col;
    }

}
