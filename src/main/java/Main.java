import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    private static String header(String schema, String signature){
        return "INSERT INTO " + schema + signature + " VALUES";
    }
    private static String randomDate(){
        String[] months={"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        Random rnd = new Random();
        int month = rnd.nextInt(12);
        int day;
        if (month == 0 || month == 2 || month == 4 || month == 6 || month == 7 || month == 9 || month == 11){
            day = rnd.nextInt(31) + 1;
        } else if (month == 3 || month == 5 || month == 8 || month == 10) {
            day = rnd.nextInt(30) + 1;
        }else{
            day = rnd.nextInt(28) + 1;
        }
        int year = rnd.nextInt(100) + 2000;
        return months[month] + " " + day + ", " + year;
    }
    public static void main(String[] args) throws IOException {
        String[] names = {"Ryan", "George", "John", "Michael", "Ethan", "Jacob", "Noah"};
        String[] surnames = {"Miller", "Jones", "Williams", "Gosling", "Pitt", "Taylor", "Hopkins", "Stanford"};
        String[] educations = {"Stanford University", "MTI University", "University of Freiburg", "ITMO UNIVERSITY", "University of Virginia"};
        String[] positions = {"Electrical Engineer", "Software Engineer", "Astrobiologist", "Robotic Engineer"};
        String[] divisions = {"Aeronautics Research", "Science", "Space Technology", "Exploration Systems Development", "Space Operations", "Mission Support"};
        String[] facilities = {"Jet Propulsion Laboratory", "Johnson Space Center", "Kennedy Space Center", "Goddard Space Flight Center", "Workshop"};
        String[] address = {"2101 E NASA Pkwy, Houston, TX 77058", "4800 Oak Grove Drive" +
                "La Cañada Flintridge, CA 91011", "Space Commerce Way, Merritt Island, FL 3295"};
        String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        String[] missions = {"Mariner", "Pathfinder", "Viking", "Gemini", "Apollo"};
        String[] missionStatuses = {"LAUNCH PHASE", "CRUISE PHASE", "ENCOUNTER PHASE", "EXTENDED OPERATIONS PHASE"};
        String[] spacecrafts = {"Perseverance","Curiosity","Spirit","Mars-30","Mars Rec. Orbiter","Alpha-X"};
        String[] spacecraftClasses = {"satellite", "rover", "copter"};
        String[] orbitExperiments = {"Optical navigation", "Orbital photography", "Surface mapping", "EM-field monitoring", "Atmosphere monitoring"};
        String[] surfaceExperiments = {"Drilling", "Soil probing", "Collecting samples", "Atmosphere probing", "Surface photography", "Life detection"};
        String[] equipment = {"NavCam","SHERLOCK","Robotic Arm","Drill","Sampling Equipment","HazCams"};
        String[] planets = {"Mars", "Phobos", "Deimos"};
        String[] orbits = {"Stationary", "Synchronous", "Polar", "Low", "Elliptic"};
        String[] rockets = {"Falcon", "Hawk", "Dove", "Eagle"};
        String[] rocketFamilies = {"Small-lift launch vehicle","Medium-lift launch vehicle","Heavy-lift launch vehicle","Super-heavy lift vehicle"};
        String[] manufacturers = {"SpaceX", "Lockheed Martin", "Boeing", "Roskosmos", "Northrop Grumman"};
        String[] launchPads = {"Cape Canaveral", "Baykonur", "Point Arguello", "Guiana Space Centre"};
        String[] launchPadLocations = {"Florida, USA", "Kazakhstan", "California, USA", "Guiana"};
        String[] weatherConditions = {"clear", "thunderstorm", "rain", "cloudy", "hurricane", "sandstorm"};
        String schema = "s307353.";
        String employeeSignature = "Employee(name, surname, education, position)";
        String employeeValue = "('%s', '%s', '%s', '%s')";
        String divisionSignature = "Division( name, head_of_division, size_of_division)";
        String divisionValue = "('%s', %d, %d)";
        String facilitySignature = "Facility(division_id,name,address)";
        String facilityValue = "(%d, '%s', '%s')";
        String experimentSignature = "Experiment(division_id,name,description)";
        String experimentValue = "(%d, '%s', '%s')";
        String equipmentSignature = "Equipment(name,description,developed_by)";
        String equipmentValue = "('%s', '%s', %d)";
        String productionSignature = "Production(equipment_id,facility_id)";
        String productionValue = "(%d, %d)";
        String employmentHistorySignature = "EmploymentHistory(employee_id,division_id,facility_id,start_date,status)";
        String employmentHistoryValue = "(%d, %d, '%s', '%s', '%s')";
        String missionSignature = "Mission(name,goal,status,description)";
        String missionValue = "('%s', '%s', '%s', '%s')";
        String spacecraftSignature = "Spacecraft(facility_id,name,class,description)";
        String spacecraftValue = "(%d, '%s', '%s', '%s')";
        String assemblingRoomSignature = "AssemblingRoom(spacecraft_id,equipment_id)";
        String assemblingRoomValue = "(%d, %d)";
        String orbitSignature = "Orbit(name, planet, characteristics)";
        String orbitValue = "('%s', '%s', '%s')";
        String rocketSignature = "Rocket(name,family,capacity_kilos,manufacturer)";
        String rocketValue = "('%s', '%s', %d, '%s')";
        String launchPadSignature = "LaunchPad(name, location)";
        String launchPadValue = "('%s', '%s')";
        String launchSignature = "Launch(launch_pad_id,mission_id,date,weather_conditions)";
        String launchValue = "(%d, %d, '%s', '%s')";
        String intendedExperimentsSignature = "IntendedExperiments(experiment_id, mission_id, equipment_id, orbit_id)";
        String intendedExperimentsValue = "(%d, %d, %d, %d)";
        String missionCharacteristicsSignature = "MissionCharacteristics(mission_id, spacecraft_id, rocket_id, orbit_id)";
        String missionCharacteristicsValue = "(%d, %d, %d, %d)";
        FileWriter writer = new FileWriter("fill_tables_script.txt");
        Random rnd = new Random();
        writer.write(header(schema, employeeSignature));
        for (int i = 0; i < 10000; i++) {
            writer.write(String.format(employeeValue,
                    names[rnd.nextInt(names.length)],
                    surnames[rnd.nextInt(surnames.length)],
                    educations[rnd.nextInt(educations.length)],
                    positions[rnd.nextInt(positions.length)]));
            if(i == 9999){
                writer.write(";\n");
            }else{
                writer.write(',');
            }
        }
        writer.write(header(schema, divisionSignature));
        for (int i = 0; i < divisions.length; i++) {
            writer.write(String.format(divisionValue,
                    divisions[i],
                    i,
                    0));
            if(i == divisions.length - 1) {
                writer.write(";\n");
            }else{
                writer.write(',');
            }
        }
        writer.write(header(schema, facilitySignature));
        for (int i = 0; i < facilities.length; i++) {
            writer.write(String.format(facilityValue,
                    rnd.nextInt(divisions.length) + 1,
                    facilities[i],
                    address[rnd.nextInt(address.length)]));
            if(i == facilities.length - 1) {
                writer.write(";\n");
            }else{
                writer.write(',');
            }
        }
        writer.write(header(schema, experimentSignature));
        for (int i = 0; i < surfaceExperiments.length; i++) {
            writer.write(String.format(experimentValue,
                    rnd.nextInt(divisions.length) + 1,
                    surfaceExperiments[i],
                    description));
            writer.write(',');
        }
        for (int i = 0; i < orbitExperiments.length; i++) {
            writer.write(String.format(experimentValue,
                    rnd.nextInt(divisions.length) + 1,
                    orbitExperiments[i],
                    description));
            if(i == orbitExperiments.length - 1) {
                writer.write(";\n");
            }else{
                writer.write(',');
            }
        }
        writer.write(header(schema, equipmentSignature));
        for (int i = 0; i < equipment.length * 100; i++) {
            writer.write(String.format(equipmentValue,
                    equipment[i / 100] + " " + ((i % 100) + 1),
                    description,
                    rnd.nextInt(divisions.length) + 1));
            if (i == equipment.length * 100 - 1) {
                writer.write(";\n");
            } else {
                writer.write(',');
            }
        }
        writer.write(header(schema, productionSignature));
        for (int i = 0; i < 10000; i++) {
            writer.write(String.format(productionValue,
                    rnd.nextInt(equipment.length * 100) + 1,
                    rnd.nextInt(facilities.length) + 1));
            if (i == 9999) {
                writer.write(";\n");
            } else {
                writer.write(',');
            }
        }
        writer.write(header(schema, employmentHistorySignature));
        for (int i = 0; i < 10000; i++) {
            if(i < 6){
                writer.write(String.format(employmentHistoryValue,
                        i + 1,
                        i + 1,
                        rnd.nextInt(facilities.length) + 1,
                        randomDate(),
                        "'hired'"));
            }else{
                writer.write(String.format(employmentHistoryValue,
                        i + 1,
                        rnd.nextInt(divisions.length) + 1,
                        rnd.nextInt(facilities.length) + 1,
                        randomDate(),
                        "'hired'"));
            }
            writer.write(",");
        }
        for (int i = 0; i < 5000; i++) {
            writer.write(String.format(employmentHistoryValue,
                        rnd.nextInt(99994) + 7,
                        rnd.nextInt(divisions.length) + 1,
                        rnd.nextInt(facilities.length) + 1,
                        randomDate(),
                        "'hired'"));
            if(i == 4999){
                writer.write(";\n");
            }else{
                writer.write(',');
            }
        }
        writer.write(header(schema,missionSignature));
        for (int i = 0; i < missions.length; i++) {
            writer.write(String.format(missionValue,
                    missions[i],
                    description,
                    missionStatuses[rnd.nextInt(missionStatuses.length)],
                    description));
            if(i == missions.length - 1){
                writer.write(";\n");
            }else{
                writer.write(',');
            }
        }
        writer.write(header(schema, spacecraftSignature));
        for (int i = 0; i < spacecrafts.length; i++) {
            writer.write(String.format(spacecraftValue,
                    rnd.nextInt(facilities.length) + 1,
                    spacecrafts[i],
                    spacecraftClasses[rnd.nextInt(spacecraftClasses.length)],
                    description));
            if(i == spacecrafts.length - 1){
                writer.write(";\n");
            }else{
                writer.write(',');
            }
        }
        writer.write(header(schema, assemblingRoomSignature));
        for (int i = 0; i < 100; i++) {
            writer.write(String.format(assemblingRoomValue,
                    rnd.nextInt(spacecrafts.length)+1,
                    rnd.nextInt(equipment.length * 100)+ 1));
            if(i == 99){
                writer.write(";\n");
            }else{
                writer.write(',');
            }
        }
        writer.write(header(schema, orbitSignature));
        for (int i = 0; i < orbits.length * 10; i++) {
            writer.write(String.format(orbitValue,
                    orbits[rnd.nextInt(orbits.length)],
                    planets[rnd.nextInt(planets.length)],
                    description));
            if(i == orbits.length * 10 - 1){
                writer.write(";\n");
            }else{
                writer.write(',');
            }
        }
        writer.write(header(schema, rocketSignature));
        for (int i = 0; i < rockets.length; i++) {
            writer.write(String.format(rocketValue,
                    rockets[i],
                    rocketFamilies[i],
                    1000 * (i + 1) * (i + 1),
                    manufacturers[rnd.nextInt(manufacturers.length)]));
            if(i == rockets.length - 1){
                writer.write(";\n");
            }else{
                writer.write(',');
            }
        }
        writer.write(header(schema,launchPadSignature));
        for (int i = 0; i < launchPads.length; i++) {
            writer.write(String.format(launchPadValue,
                    launchPads[i],
                    launchPadLocations[i]));
            if(i == launchPads.length - 1){
                writer.write(";\n");
            }else{
                writer.write(',');
            }
        }
        writer.write(header(schema,launchSignature));
        for (int i = 0; i < 100; i++) {
            writer.write(String.format(launchValue,
                    rnd.nextInt(launchPads.length) + 1,
                    rnd.nextInt(missions.length) + 1,
                    randomDate(),
                    weatherConditions[rnd.nextInt(weatherConditions.length)]));
            if(i == 99){
                writer.write(";\n");
            }else{
                writer.write(',');
            }
        }
        writer.write(header(schema, intendedExperimentsSignature));
        for (int i = 0; i < 100; i++) {
            writer.write(String.format(intendedExperimentsValue,
                    rnd.nextInt(surfaceExperiments.length + orbitExperiments.length) + 1,
                    rnd.nextInt(missions.length + 1),
                    rnd.nextInt(equipment.length * 100) + 1,
                    rnd.nextInt(orbits.length * 10) + 1));
            if(i == 99){
                writer.write(";\n");
            }else{
                writer.write(',');
            }
        }
        writer.write(header(schema, missionCharacteristicsSignature));
        for (int i = 0; i < 1000; i++) {
            writer.write(String.format(missionCharacteristicsValue,
                    rnd.nextInt(missions.length) + 1,
                    rnd.nextInt(spacecrafts.length) + 1,
                    rnd.nextInt(rockets.length) + 1,
                    rnd.nextInt(orbits.length * 10) + 1));
            if(i == 999){
                writer.write(";\n");
            }else{
                writer.write(',');
            }
        }
        writer.close();
    }
}
