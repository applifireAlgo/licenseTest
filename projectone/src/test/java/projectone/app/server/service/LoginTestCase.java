package projectone.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import projectone.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import projectone.app.server.repository.LoginRepository;
import projectone.app.shared.authentication.Login;
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
import projectone.app.shared.contacts.CoreContacts;
import projectone.app.server.repository.CoreContactsRepository;
import projectone.app.shared.contacts.Gender;
import projectone.app.server.repository.GenderRepository;
import projectone.app.shared.location.Language;
import projectone.app.server.repository.LanguageRepository;
import projectone.app.shared.location.Timezone;
import projectone.app.server.repository.TimezoneRepository;
import projectone.app.shared.contacts.Title;
import projectone.app.server.repository.TitleRepository;
import projectone.app.shared.authentication.User;
import projectone.app.server.repository.UserRepository;
import projectone.app.shared.authentication.UserAccessDomain;
import projectone.app.server.repository.UserAccessDomainRepository;
import projectone.app.shared.authentication.UserAccessLevel;
import projectone.app.server.repository.UserAccessLevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(101);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("7F3kbKY1f7psK0E9rNrzuCFAvjC9taL5w3N91gXSvtV8WrSx2j");
            corecontacts.setFirstName("BdObmFGUzikQIUmXhpdhTKrGh3SJER0u1xJlCutiZqnJ6NVn2k");
            Gender gender = new Gender();
            gender.setGender("clsLzitfcmrmw6vwW3jfbineWwZwdJWvLfpMk6KzTluReFhSE1");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("Rj");
            language.setAlpha3("2eF");
            language.setAlpha4("ITF4");
            language.setAlpha4parentid(4);
            language.setLanguage("VXuXgk3Ft7mJdnD5VhXUJNTC283R3Z7bUfl0z0rAeVYtM7hnUt");
            language.setLanguageDescription("FVlqX4Vqw2RM1WNQwz8qCL47iQhvNLLMcbr8WJCHnnGKVuExVy");
            language.setLanguageIcon("aarbpza2qliOaiDmD5lbJihwF3DVXJeC2rrpTURpvZbuNIepyZ");
            language.setLanguageType("PqgXcZunWhVrKPZbS1Qc4kobQP9hfUmC");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("qRySnM7iG3NkTo0TGirfezi0VKVzKM38b0MwWO5cop2ronsrXR");
            timezone.setCountry("s1roG6DI8Tu2IunvOWYdPAJ0XHne7zNGg4awhk4uzwwVS9gLYl");
            timezone.setGmtLabel("wxTMwRnQZdsbmvUl2fjhhbnntNF109uWgbEsZKuh0aI8kpY2qH");
            timezone.setTimeZoneLabel("MvN4Wcoek6Hi1otyXWg1RwPbVSTJ5bbc6CQLbG8o3Thwu3IROi");
            timezone.setUtcdifference(1);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("MeUb3eHDLkT0u0ER3LlqO2CNsCshSbPRtPVxTKN40NqTjBxAhU");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(98);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("lcaIU8kyXcdUpOTZg7b0SOP0m4wB5hQQnw7WkB0g8ssWw37Dlt");
            corecontacts.setFirstName("IARqGcBQOuijU2i6AEjyjNJ8tBNIa5CxcpurbICgLmZ6g55nj3");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("FlWvU3zsBb3Tw2AAnoD9Q0uctb3bHfXzN9dlGZ1ugmZb18sn3z");
            corecontacts.setMiddleName("9mZQgIWAk9FdBMSyo5ZGIGDsi6IzpivalA0QmvA23qjcJbVU1t");
            corecontacts.setNativeFirstName("cAhxkIY6Yvp1iQ6QNa480u7LFIMwZ8W4PmY5FwgY1ob2LjcMks");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("mrJaM1SKEk3XgjYOQ7MFBEc3js127Lga44skc0n9HylciVOETJ");
            corecontacts.setNativeMiddleName("jtGq4qfX7oPwib6rJRjEak2lqpnQtakvkzI2fa9Kgx76zez9E4");
            corecontacts.setNativeTitle("WlM1Q1BFM99uSMKP0bY7lACS76ADdQf0vLmSq9yfZKXQT2ZynQ");
            corecontacts.setPhoneNumber("WHHxCea7AEsHMHc3qjDP");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("qmIb2zubi3tctJYR5Q3xOZZOeXrAbuiSJf17omhggPaqxVk5iA");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(620);
            user.setUserAccessCode(8);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("8eBhoz57ZedjcwxE8bvl1fGxg86rLWbgPnNIpycECOmTScJyUL");
            useraccessdomain.setDomainHelp("CoSTUoyIazI51Bu4DhvsbeZjZK5JdAWOyMgWcclrVUGQ6Uv5tt");
            useraccessdomain.setDomainIcon("qmEbmAT4EDXFTfoxkMvbxG1CaiqXBfvifKrrwC4hTXbZMHmbbK");
            useraccessdomain.setDomainName("QPPMGirf4Mb7ENQViUbzG79k8qXrAlIa1wLWzH3SiTTInPIUVz");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("a2wzUQNF6t7YemSRD5EoXmRfTv0pe3NOmAfAANWQ5jklGSSO6v");
            useraccesslevel.setLevelHelp("ApZzwWxm6bV6oxNgZL6OHHkXDHKuT9a5GzIsOGV8oX7yYHNVLU");
            useraccesslevel.setLevelIcon("bZdKPmjI9hClACAbP8iG50kXkQtE6taOooeIY2wj5rDE2nXJFf");
            useraccesslevel.setLevelName("72Fh86TukeRnuAYBcfLoapxc8NefjEaXEcMCP6ZF2OpyjSCQWx");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("UUtOwqOyQFVePSUx9yWOEfjVWaYWJ5AQOgSbIAMmitApmnOb0G");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1383);
            user.setUserAccessCode(4);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(5);
            login.setIsAuthenticated(true);
            login.setLoginId("wvxewEsbdpgiVgCHaHePhfCwwDDSDfgK73xiYSBmHlxzSvvkR1");
            login.setServerAuthImage("rP4GP81R6nZ9o1sL5CUT9MLFmQdkI7Sm");
            login.setServerAuthText("bPsNZwXjPKfdxiBO");
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(1);
            login.setLoginId("izZinm0eU3kvvmMjrni1gS9AllovNNV3MWtv6l9vSjP4Tmw7IX");
            login.setServerAuthImage("rUONICWN2aQHddc6eNW7A4qG9kJWYoG1");
            login.setServerAuthText("pC49P7C8btgG8Dag");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
