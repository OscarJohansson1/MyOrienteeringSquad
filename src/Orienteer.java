import Actions.Specialist;

/**
 * The Orienteer class describes and performs actions on an orienteer.
 */

public class Orienteer {
    private final String name;
    private int age;
    private int id;
    private static int idCount = 1;
    private int score;
    private int speed;
    private int stamina;
    private int strength;
    private int technicalSkills;
    private int routechoiceSkills;
    private Specialist specialist;
    private int motivation = 50;
    private int daysSinceLastTraining = 0;
    private boolean retired = false;

    public Orienteer(String name, int age, int speed, int stamina, int strength, int technicalSkills, int routechoiceSkills) {
        this.name = name;
        this.age = age;
        this.speed = speed;
        this.stamina = stamina;
        this.strength = strength;
        this.technicalSkills = technicalSkills;
        this.routechoiceSkills = routechoiceSkills;
        updateSpecialist();
        updateScore();
        id = idCount;
        idCount++;
    }

    // Increase stats
    public void increaseSpeed(int n) {
        speed += n;
        updateScore();
    }

    public void increaseStamina(int n) {
        stamina += n;
        updateScore();
    }

    public void increaseStrength(int n) {
        strength += n;
        updateScore();
    }

    public void increaseTechnicalSkills(int n) {
        technicalSkills += n;
        updateScore();
    }

    public void increaseRoutechoiceSkills(int n) {
        routechoiceSkills += n;
        updateScore();
    }

    public void increaseDaysSinceLastTraining() {
        daysSinceLastTraining++;
        updateMotivation();
    }

    // Decrease stats
    public void decreaseSpeed(int n) {
        speed -= n;
        updateScore();
    }

    public void decreaseStamina(int n) {
        stamina -= n;
        updateScore();
    }

    public void decreaseStrength(int n) {
        strength -= n;
        updateScore();
    }

    public void decreaseTechnicalSkills(int n) {
        technicalSkills -= n;
        updateScore();
    }

    public void decreaseRoutechoisSkills(int n) {
        routechoiceSkills -= n;
        updateScore();
    }

    // The name explains it all
    public void setDaysSinceLastTrainingToZero() {
        daysSinceLastTraining = 0;
    }

    // Update methods to update variables depending on other variables
    private void updateScore() {
        int prelScore;
        if (specialist == Specialist.SPRINT) {
            prelScore = 3 * speed;
            prelScore += 2 * routechoiceSkills;
            prelScore += technicalSkills + strength;
            prelScore /= 7;
        } else if (specialist == Specialist.MIDDLE) {
            prelScore = 3 * technicalSkills;
            prelScore += 2 * speed;
            prelScore += strength + stamina;
            prelScore /= 7;
        } else {
            prelScore = 2 * stamina;
            prelScore += 2 * strength;
            prelScore += 2 * routechoiceSkills;
            prelScore += speed + technicalSkills;
            prelScore /= 8;
        }
        score = prelScore;
    }

    private void updateSpecialist() {
        int sprint = (speed + routechoiceSkills) / 2;
        int middle = (technicalSkills + speed) / 2;
        int longdistance = (stamina + strength + routechoiceSkills) / 3;
        if (sprint >= middle && sprint >= longdistance) {
            specialist = Specialist.SPRINT;
        } else if (middle >= longdistance) {
            specialist = Specialist.MIDDLE;
        } else {
            specialist = Specialist.LONG;
        }
    }

    private void updateMotivation() {
        if (daysSinceLastTraining > 0) {
            motivation -= 3 * daysSinceLastTraining;
        } else {
            motivation += 5;
        }
        // Check if retired, lack of motivation is a real killer in sports
        if (motivation <= 0) {
            retired = true;
        }
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStamina() {
        return stamina;
    }

    public int getStrength() {
        return strength;
    }

    public int getTechnicalSkills() {
        return technicalSkills;
    }

    public int getRoutechoiceSkills() {
        return routechoiceSkills;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public int getMotivation() {
        return motivation;
    }

    public int getDaysSinceLastTraining() {
        return daysSinceLastTraining;
    }

    public boolean isRetired() {
        return retired;
    }
}
