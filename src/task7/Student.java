package task7;

/**
 * Created with IntelliJ IDEA.
 * User: sturovskiy
 * Date: 09.10.12
 * Time: 14:24
 * To change this template use File | Settings | File Templates.
 */
public class Student
{
  private String login;
  private String name;
  private String faculty;
  private String telephone;
  private Address address = new Address();

  public String getLogin()
  {
    return login;
  }

  public void setLogin(String login)
  {
    this.login = login;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getFaculty()
  {
    return faculty;
  }

  public void setFaculty(String faculty)
  {
    this.faculty = faculty;
  }

  public String getTelephone()
  {
    return telephone;
  }

  public void setTelephone(String telephone)
  {
    this.telephone = telephone;
  }

  public Address getAddress()
  {
    return address;
  }

  public void setAddress(Address address)
  {
    this.address = address;
  }

  public String toString()
  {
    return "Login: " + login
            + "\nName: " + name
            + "\nTelephone: " + telephone
            + "\nFaculty: " + faculty
            + "\nAddress:"
            + "\n\tCountry: " + address.getCountry()
            + "\n\tCity: " + address.getCity()
            + "\n\tStreet: " + address.getStreet()
            + "\n";
  }

  public class Address
  {
    private String country;
    private String city;
    private String street;

    public String getCountry()
    {
      return country;
    }

    public void setCountry(String country)
    {
      this.country = country;
    }

    public String getCity()
    {
      return city;
    }

    public void setCity(String city)
    {
      this.city = city;
    }

    public String getStreet()
    {
      return street;
    }

    public void setStreet(String street)
    {
      this.street = street;
    }
  }
}

