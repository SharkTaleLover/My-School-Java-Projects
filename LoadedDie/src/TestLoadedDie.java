public class TestLoadedDie
{

    public static void main(String[] args)
    {
        int firstDieHigher = 0;
        int beatLoadedDie = 0;
        int trials = 0;
        Die die1 = new Die();
        Die die2 = new Die();
        LoadedDie loadedDie = new LoadedDie();

        for(int i = 0; i < 1000; i++)
        {
            if(die1.getRoll() > die2.getRoll())
                firstDieHigher += 1;
            die1.setRoll();
            die2.setRoll();
        }

        for(int j = 0; j < 1000; j++)
        {
            if(die1.getRoll() > loadedDie.getRoll())
                beatLoadedDie += 1;
            loadedDie.setRoll();
            die1.setRoll();
        }

        System.out.println("In the first trial, Die 1 rolled higher " + firstDieHigher + " times out of 1000.");
        System.out.println("In the second trial, Die 1 rolled higher " + beatLoadedDie + " times out of 1000.");
    }
}
