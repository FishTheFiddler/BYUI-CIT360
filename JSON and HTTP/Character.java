package MassEffectJSON;

public class Character {

    public String name;
    public String species;
    public int firstAppearance;
    public boolean isMale;


    // NAME FUNCTIONS
    public String getName(){
        return name;
    }
    public String setName(String jname){
        this.name = jname;
        return name;
    }

    // SPECIES FUNCTIONS
    public String getSpecies(){
        return species;
    }
    public String setSpecies(String jspecies){
        this.species = jspecies;
        return species;
    }

    // FIRST APPEARANCE FUNCTIONS
    public int getAppearance(){
        return firstAppearance;
    }
    public int setAppearance(int jfirstAppearance){
        this.firstAppearance = jfirstAppearance;
        return firstAppearance;
    }

    // ISMALE FUNCTIONS
    public boolean getIsMale(){
        return isMale;
    }
    public boolean setIsMale(boolean isMale){
        this.isMale = isMale;
        return isMale;
    }

    public String toString(){
        System.out.println("Name: " + name);
        System.out.println("Species: " + species);
        System.out.println("First Appeared in Mass Effect " + firstAppearance);
        if (isMale) {
            System.out.println("Gender: Male");
        } else {
            System.out.println("Gender: Female");
        }
        return "End of Program";
    }

}
