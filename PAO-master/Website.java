package eLearn;

public class Website {
    String link;
    String subscriptionFee;
    int duration;
    int trialDays;
    String difficulty;

    public Website(String link, String subscriptionFee, int duration, int trialDays, String difficulty){
        this.link = link;
        this.subscriptionFee = subscriptionFee;
        this.duration = duration;
        this.trialDays = trialDays;
        this.difficulty = difficulty;
    }

    Website(Website copy_this){
        this.link = copy_this.link;
        this.subscriptionFee = copy_this.subscriptionFee;
        this.duration = copy_this.duration;
        this.trialDays = copy_this.trialDays;
        this.difficulty = copy_this.difficulty;
    }

    public Website getWebsite(){
        return new Website(this);
    }

    public void getInfo(){
        if(trialDays == 0)
            System.out.printf("[Link : ] %s \n[Price : ] %s \n[Duration : ] %d\n[Difficulty : ] %s\n",
                                link, subscriptionFee, duration, difficulty);
        if(trialDays == 1)
            System.out.printf("[Link : ] %s \n[Price : ] %s \n[Duration : ] %d\n [Trial Days : ] %d\n[Difficulty : ] %s\n",
                                link, subscriptionFee, duration, trialDays, difficulty);
    }
}
