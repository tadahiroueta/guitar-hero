public class GuitarHero {
    final static String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    public static void main(String[] args) {
        // make guitar strings
        GuitarString[] strings = new GuitarString[KEYBOARD.length()];
        for (int i = 0; i < strings.length; i++)
            strings[i] = new GuitarString(440 * Math.pow( 1.05956, (i - 24)));

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = KEYBOARD.indexOf(key);
                if (index != -1)
                    strings[index].pluck();
                else 
                    System.out.println("Invalid key: " + key);
            }
            double sample = 0;
            for (GuitarString string : strings) {
                sample += string.sample();
                string.tic();
            }
            StdAudio.play(sample);
        }
    }
}
