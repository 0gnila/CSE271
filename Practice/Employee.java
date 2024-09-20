public class Employee 
{
    // Declare instance variables as private
    private static String name;
    private static int age;
    private static String address;

    // Getter method
    public String getName() 
    {
        return name;
    }

    // Setter method
    public void setName(String name) 
    {
        this.name = name;
    }
    // Getter method
    public int getAge() 
    {
        return age;
    }

    // Setter method
    public void setAge(int age) 
    {
        this.age = age;
    }

    // Getter method
    public String getAddress() 
    {
        return address;
    }

    // Setter method
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public static void main(String[] args)
    {
        // Creat two objects of Employee class and try to call the different instance methods
        Employee emlpoyee1 = new Employee();

        emlpoyee1.setAddress("Oxf");
        emlpoyee1.setName("John");
        emlpoyee1.setAge(20);

        System.out.println(emlpoyee1.getName());
        System.out.println(emlpoyee1.getAddress());
        System.out.println(emlpoyee1.getAge());
        // Also, try to call the instance variables on the objects and see what would happen
    }
}
