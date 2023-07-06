class ResistorColor {
    int colorCode(String color) {
        String[] colorCoding = colors();
        for(int i=0;i<colorCoding.length;i++){
            if(color == colorCoding[i])
                return i;
        }
        return 0;
    }

    String[] colors() {
        String[] allColors = {
            "black",
            "brown",
            "red",
            "orange",
            "yellow",
            "green",
            "blue",
            "violet",
            "grey",
            "white"
        };
        return allColors;
    }
}
