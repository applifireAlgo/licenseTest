package projectone.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import projectone.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import projectone.app.server.repository.CoreContactsRepository;
import projectone.app.shared.contacts.CoreContacts;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import projectone.app.shared.contacts.Gender;
import projectone.app.server.repository.GenderRepository;
import projectone.app.shared.location.Language;
import projectone.app.server.repository.LanguageRepository;
import projectone.app.shared.location.Timezone;
import projectone.app.server.repository.TimezoneRepository;
import projectone.app.shared.contacts.Title;
import projectone.app.server.repository.TitleRepository;
import projectone.app.shared.location.Address;
import projectone.app.server.repository.AddressRepository;
import projectone.app.shared.location.AddressType;
import projectone.app.server.repository.AddressTypeRepository;
import projectone.app.shared.location.City;
import projectone.app.server.repository.CityRepository;
import projectone.app.shared.location.Country;
import projectone.app.server.repository.CountryRepository;
import projectone.app.shared.location.State;
import projectone.app.server.repository.StateRepository;
import projectone.app.shared.contacts.CommunicationData;
import projectone.app.shared.contacts.CommunicationGroup;
import projectone.app.server.repository.CommunicationGroupRepository;
import projectone.app.shared.contacts.CommunicationType;
import projectone.app.server.repository.CommunicationTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            Gender gender = new Gender();
            gender.setGender("DcllCeRS93ScYg3XjCoa4XqBMfg1XHFD4bPMJvn5JR1vt1rofl");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("rw");
            language.setAlpha3("4L3");
            language.setAlpha4("Qxwj");
            language.setAlpha4parentid(5);
            language.setLanguage("hCqDwNoMkbaOdYDP4PADZhjO9dJ7tCSQK6FFcdNViAQrrZFkro");
            language.setLanguageDescription("8cM332Ks0ALYkdwPcW0qlzW6zEusIlHUCmkUZNj6Iqh8E7ws2r");
            language.setLanguageIcon("d4eh8u7Gns3U0K1xvi8kOv2HAKIv8ZMM3044SfT6kLbqCUln88");
            language.setLanguageType("Qoy2HKw18Na7Xp1T3ty1ZTV7gdjfVdwa");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("fH3XFkbCUE8QsRvlFd64Iz4OrLdquBKKYqleo3Sj4uW2kek8nA");
            timezone.setCountry("YIH9WsMX9ygKxGqvvo6copPKcVi0SIFz6Ni9cPM0rTyCS6rxxg");
            timezone.setGmtLabel("48NT7moZrXjDx6rUEsxd9mQQsA4exPcyY1XBr0KYsOd5AiFx4B");
            timezone.setTimeZoneLabel("MUI3rzj5tHHfnd4MIDrkr9XCTzgIrO1FrwGzzfMoKXRamkqPYx");
            timezone.setUtcdifference(7);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("P0nFhaBFPOJbLtPqwzrGvqmqm0mbpFDTwiRLNWbmsrJXEVQpc6");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(119);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("E0bixB1dcHu3KLyJEXN1PFWjFSExk18F5PrwxegHcOe1lSTi8u");
            corecontacts.setFirstName("2i49DujEVMKYf2LyarK9qbp2BlRyAM73AbxmfQUkNWVkIVYN3p");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("Yh1rZhvjfMbXeMryGWYY39zngReB1r9wf4grTucPvfckNktPgL");
            corecontacts.setMiddleName("MMH0RN93zfuN3v75J8ztMZwB5vKcBJ7FShsdBjIN0mnutWynHt");
            corecontacts.setNativeFirstName("V4U3i22SGQ97pOAKzoxaR7ro52Yn9TuiMxsgjtv9DvnK7zqY8F");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("IDRfsjQzazHXaNSgf1BxzxziTvkgJ8RJ4JPj8rFll3JFfNledP");
            corecontacts.setNativeMiddleName("5ha6tEIHdvv1MrbE0cX3zlxqYmhatAv4ZU7Zs8j5oOveqTAfS5");
            corecontacts.setNativeTitle("wnPiGttTwmwFNpPeasZ8uSoJOhBTT5QfaOyQNMgqALDzVLhInU");
            corecontacts.setPhoneNumber("C8vqtMGyKm4ohgeAvkPr");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("hY5hTbaMT3wXQiElGPpAJoldXPdWDTa0oebwjI3qH2GiJwfpy7");
            address.setAddress2("E5PvkXYoPyLOUchzhJz4pZheTp8MsPYR9SpmlJCgZArUNbIsQX");
            address.setAddress3("yFansB0XKSnb9TeOY37YOhGe9IAjbvnocN5gmhqn1CGE0N8CW7");
            address.setAddressLabel("awfBgL2V2h9");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("Zmw3jHFDpaedjIAHypRV9V12Z6ACbm8bGdmXNtrFs0lt7K0Ns8");
            addresstype.setAddressTypeDesc("gg2E5rLJvufimp0fdORMr2HjUnPfMlWRZbn9HrkZKPwwH82ZA6");
            addresstype.setAddressTypeIcon("KAyJDO1x6yazpQ14YubsAuDOkRFMFfPa2duvkBLHN0kRMmQ8tI");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("KDCeVSVVBa4TyD3Kfi58OJShsHslWwqn");
            city.setCityDescription("PVbM8mAJvDFEhjan1IFy2nFzmmmzFseUb1DLeT1XVua1ua1hbH");
            city.setCityFlag("NYXneu1z0p9Quh1eRIFUUbA5atxXiJuhabdonPl7sQh95BBG63");
            city.setCityLatitude(2);
            city.setCityLongitude(2);
            city.setCityName("hQOpDEEcXCsLuqYsGiFWZyPTEa5D2ZCVAJh6eeRVE61EhFPq6X");
            Country country = new Country();
            country.setCapital("gh672efgx1OePl5XwK4bWd4oU2U4GHT5");
            country.setCapitalLatitude(10);
            country.setCapitalLongitude(0);
            country.setCountryCode1("5XO");
            country.setCountryCode2("TiN");
            country.setCountryFlag("6jf4FBCu9LjG3LA1jcETIDP06ZDD9RL6eouEQg5wlHuBE4JzWw");
            country.setCountryName("TVoKaR7WN0o91uouBK2NuUjpUqYLYhPshxqQdSg93ktnMG5Wmj");
            country.setCurrencyCode("IeI");
            country.setCurrencyName("TGfX7lGdQVCGhCtaq0GwVt8hGZDsIa1iah8GUtu3aDnRb55I47");
            country.setCurrencySymbol("DSr2CY6rR8SzE4LU4Hi9LVsJrgsf6ntG");
            country.setIsoNumeric(0);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("nn2kjCjo06vIDeM4T7CVOhf0mH9ptKHdiCs9MkwgtASJHZ5MM6");
            state.setStateCapitalLatitude(7);
            state.setStateCapitalLongitude(8);
            state.setStateCode(0);
            state.setStateCodeChar2("gYn2xn1Z4lkuIT9HzxvPnsX39QwVuGgH");
            state.setStateCodeChar3("WEPJxsy9ZJglZvo5YPX23JRwyvB5xDLh");
            state.setStateDescription("BhUXBuSjfobQB3IMppMD9TcLkUROjG34gu4tv8uMqU6GcUbg64");
            state.setStateFlag("iFRpkNRsaIo8dG2ijZYWFk6l5y5LEl6aTlZydoiV7mVb3OQg3g");
            state.setStateName("1jVLc1KdcwAW8VtWGMOj2yBy5uf6hhkUD4yKp0JQlWo3s2wVHU");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("zIu6b5S1ejlxi05oIUL4olfxNtk6Ys8y");
            city.setCityDescription("Rh78EkGYmuy7zac6zaqkvz3nnS5kgTi1FmVYSMVeOXkv3S7Icb");
            city.setCityFlag("AS55RpnxHeigGC5TG30ULDnepOvuQXDtgoVQHBvs7eD9VjDqV8");
            city.setCityLatitude(9);
            city.setCityLongitude(10);
            city.setCityName("FIN9CToJMK1eU4SYtQQ0PT7H95WU0tp9oqY5J5LYoz7KMkWMgE");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("uJJMBOEFoqu81saKgyo7Bgb0WZmOL730TuUv2Svhfet7xFQqwX");
            address.setAddress2("EjTsXXQ0kvPHXdMI7nQdN5N4SO3X1fGPDgZiAXAQpTH6RDH37h");
            address.setAddress3("p9kkYGLNJurdJwaFb886mATWPpaplgF7UxyKGSBvvVt71YK2Mn");
            address.setAddressLabel("1Kj1lL2o4B8");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("Zep7cUKkaxXAM7WoFVPxK00sdBAHiExtJUJg2Qjz04yoT5K3tx");
            address.setLongitude("YT7fj3O96CbkSVOmO0vKm0WAEUx8cYdT2X608om6FjQA4XB45L");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("lzvtog");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("LHG");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("eMm5hOMLAqMZNT0SiIIbyVkB76BRzisDwJ79C8eUlAtarm8lKF");
            communicationgroup.setCommGroupName("hKItdXnnYMKo5u3uTVH93UCu4GMNb3gPM8Vm0q9hNUwmcO0KtX");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("gbhA4u4outq8TULkt3YH4YyWpVuj6X1r3nqRP6VketvE5UstzP");
            communicationtype.setCommTypeName("QqvInHIE0pYnbXAGZWiepu6aHAIdkH1kLoXTry1DM4OWe2O02L");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("bVK");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(92);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("zrQTfzLnnTHQohHnrIR1KDstdOQgBqcdhFeNSKtQl2DE0juUQd");
            corecontacts.setFirstName("PQhBXsc4exGAME4Wz2VmREKHPb4djCzGph3nQ0KCWIePQ5rifF");
            corecontacts.setLastName("cL61wUdsYQMv3ZH7hQdVLUKP5P1dPtUS1RNfkpfH6igNu6Qkhe");
            corecontacts.setMiddleName("NiWhZiq43anOYBECg9xxx6gYmcxuFuDKpcFOpmY5P2edlmJgq5");
            corecontacts.setNativeFirstName("szXoZJu82XY0AEFPRX3vP0oXxCxWYmzzJ9z9noLCyfB2XC5UJ9");
            corecontacts.setNativeLastName("WFrGcxXZnnW4lvV0SCtqDHvsTgkz80kYYHodxFLEJnKLksKSAr");
            corecontacts.setNativeMiddleName("J1we2UFdtNZKNkPJEaiceVJFis8lE1x0SW9VxwZnO7ECSNLTj6");
            corecontacts.setNativeTitle("2x1USRvqtj4Cko0QlnlCPmgDs46mnGbNlu9qxuM1vQCvfLiOnl");
            corecontacts.setPhoneNumber("MQFtt6MgltMu325OLv4e");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytimeZone() {
        try {
            java.util.List<CoreContacts> listoftimeZone = corecontactsRepository.findByTimeZone((java.lang.String) map.get("TimezonePrimaryKey"));
            if (listoftimeZone.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
