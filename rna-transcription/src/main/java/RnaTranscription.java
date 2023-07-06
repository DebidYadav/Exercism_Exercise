class RnaTranscription {

    String transcribe(String dnaStrand) {
        //StringBuilder ans = new StringBuilder();
        String ans = "";
        for(char ch : dnaStrand.toCharArray()){
            switch(ch){
                case 'G' : ans+='C';
                    break;
                case 'C' : ans+='G';
                    break;
                case 'T' : ans+='A';
                    break;
                case 'A' : ans+='U';
                    break;
                default: ans+="";
                    break;
            }
        }
        return ans;
    }

}
