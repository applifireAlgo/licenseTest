package projectone.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import projectone.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import projectone.app.server.repository.AddressRepository;
import projectone.app.shared.location.Address;
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
import projectone.app.shared.location.AddressType;
import projectone.app.server.repository.AddressTypeRepository;
import projectone.app.shared.location.City;
import projectone.app.server.repository.CityRepository;
import projectone.app.shared.location.Country;
import projectone.app.server.repository.CountryRepository;
import projectone.app.shared.location.State;
import projectone.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("sfgbAenj7DApT7VPbhIQjUQh7mZsRsNJcSyZR4xhcEemrIiEOy");
            addresstype.setAddressTypeDesc("6zuBzGA42xpxOePosJizgwQL13pAicyM51Oe7rd2fbZPlgK9rD");
            addresstype.setAddressTypeIcon("rlY4ozfmSNKMUyfBDjfTjZvKGlJGsJtf8bUVQIcAtOaeDIKNTC");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("CXN9wRZA7JTaF9vvXTPZedYV1XY73JM5");
            city.setCityDescription("sNUBGPMzHlYH412lm8RcTzEwXVRxzc1nQos66IoinzzuuUZzpy");
            city.setCityFlag("1pdbJ4xBZ18c56Pz2vecD4o6t3r35jcVayanLFomQGwqGVZSo3");
            city.setCityLatitude(6);
            city.setCityLongitude(6);
            city.setCityName("ZJtaJS1ipOQEnt3gfsbOyVn3U25TK0nsz9lRgAcRPP7C043v9a");
            Country country = new Country();
            country.setCapital("Wo7xinrxdcOzfkDae25LCE7pk3auPb4l");
            country.setCapitalLatitude(3);
            country.setCapitalLongitude(5);
            country.setCountryCode1("CDt");
            country.setCountryCode2("bl2");
            country.setCountryFlag("ox321jN5sozc8ex0vuTYgqtQqG6vAd2lcf18W8LC9s2xt1gJOI");
            country.setCountryName("hVmI58rZy2U675fkbN7vEE7kGf8pK6hAIjzPvjvfqkr8sRgYiS");
            country.setCurrencyCode("LiZ");
            country.setCurrencyName("VZqZ8ZssWG2t8lUlJs1FBJCjb4EEaIE2mtlTKAtdG71DOyZgVd");
            country.setCurrencySymbol("vT7TDQVk35CgoXOohE6tAv4viyiHxv4m");
            country.setIsoNumeric(11);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("ebTGkiYpHJPMUTLS67UOTmuhaesmHidPuBySw0vYgQTe37oaUk");
            state.setStateCapitalLatitude(7);
            state.setStateCapitalLongitude(4);
            state.setStateCode(2);
            state.setStateCodeChar2("MaJxdgaaiCwUUXDBOEX3PyvxYHvf421T");
            state.setStateCodeChar3("tVnwoeaUhQZ2A5eGvlwDpEi55gBvdJ5w");
            state.setStateDescription("VeNCSIzolGsUqsTRH3c2ZHV7ULzMwPPrdHLakPDleuCysfzEsJ");
            state.setStateFlag("KRIAEplONhupdQ19VycgAAFIa3F0TbfdN0p2R6D9oMVjvWhMCl");
            state.setStateName("NblnESvAQ6J97lTsUcQFy0Es0OJJdiT1KwNmHauTwf1mrX78AB");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("bzcVCwEu8CTsZjCFDK6jPzw64cVzPe7L");
            city.setCityDescription("8bm4e66VMN1FlIF18FifYQoJst9umuIS61W9drlJl36TuX5CWp");
            city.setCityFlag("QLRKRLhNa7AA5bZpVMEfmk8nJU96WMbbmsTtFYaVTnVXI23q60");
            city.setCityLatitude(9);
            city.setCityLongitude(7);
            city.setCityName("Pe5eJ4qwqIoXt3L1qR9pAG9xel49qdKqZ2O5Yf5ajVA6EY8A8j");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("qkPXuitswKgVG13qoy3fDxpcjTP2NhiNhil5IEsMSyODk56azb");
            address.setAddress2("f5QyP8ALNwPRPxPL9Fgt0umN2WU7siYqxU9WKs8s0exBp3AmtK");
            address.setAddress3("Yq7Xmf1wPb5lzSfklipo0FKMPJxNZKBEA7UuSwTkspxgKSkx2R");
            address.setAddressLabel("hUmliirRrkO");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("xRo7VOwfBXx3ENH8IK46YtVWiDPd6MBDtreokOGn8PsurHvb9f");
            address.setLongitude("wSkcURKmhBtpmTKUcBmy2VK3JglGNXQ7j8UaSZLPVPrtKzatO4");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("dnww3d");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("qVCdZ4rUh8zfj875mJYyN64zHk1aq5lqw1IwWUhgzUUb1xwftF");
            address.setAddress2("px3Sepl2zj1JQRAvN4hIQN3r1uDkcxhdvlkQoJWeRFFDCvJ0u1");
            address.setAddress3("IomHmfjIDYgBgbXdoBiszDvJoDczLGV9OsX6QLK1pCCqgfWXZ6");
            address.setAddressLabel("sCUxQB32wdg");
            address.setLatitude("aFXEPPG5NyBnJGqvN3LiAUrn2w3JgytIFnQAHsTRIKLloy5Ry8");
            address.setLongitude("3TIcoGLSozELtU5Kt1l6ZaI7ZbkECz6UVO5GEYQo5ACur7fmau");
            address.setVersionId(1);
            address.setZipcode("5arLFb");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
