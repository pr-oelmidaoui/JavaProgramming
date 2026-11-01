package ma.dentalPro.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import ma.dentalPro.repository.api.PatientRepo;
import ma.dentalPro.service.api.PatientService;
import ma.dentalPro.ui.controllers.api.PatientController;

// Factory - Singleton

public class ApplicationContext {

   private final static ApplicationContext INSTANCE = new ApplicationContext() ;

    Map<Class<?>, Object> beansByclass = new HashMap<>();

    private ApplicationContext() {

        try {
            var cl = Thread.currentThread().getContextClassLoader();
            var configFile = cl.getResourceAsStream("application.properties");

            Properties props = new Properties();
            props.load(configFile);

            var patientRepoClassName = props.getProperty("dao.patientDao");
            var patientServiceClassName = props.getProperty("service.patientService");
            var patientControllerClassName = props.getProperty("controller.patientController");

            var cPatientRepo = Class.forName(patientRepoClassName);
            var cPatientService = Class.forName(patientServiceClassName);
            var cPatientCtr = Class.forName(patientControllerClassName);

            PatientRepo repo = (PatientRepo)cPatientRepo
                                        .getDeclaredConstructor()
                                        .newInstance();
            PatientService service = (PatientService)cPatientService
                                        .getDeclaredConstructor(PatientRepo.class)
                                        .newInstance(repo);
            PatientController controller = (PatientController)cPatientCtr
                                        .getDeclaredConstructor(PatientService.class)
                                        .newInstance(service);


            beansByclass.put(PatientRepo.class, repo);
            beansByclass.put(PatientService.class, service);
            beansByclass.put(PatientController.class, controller);

        }
        catch (NullPointerException e) {
            System.err.println("Error while finding application.properties file : " + e.getMessage());
        }
        catch (IOException e) {
            System.err.println("Error loading data from properties file : " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            System.err.println("Error while loading Class (Class Name may be wrong ) : " + e.getMessage());
        }
        catch (NoSuchMethodException e) {
            System.err.println("Error while calling Constructor  : " + e.getMessage());
        }
        catch (InstantiationException e) {
            System.err.println("Error while creating instance   : " + e.getMessage());
        }
        catch (Exception e) {
            System.err.println("Error   : " + e.getMessage());
        }

    }

    public static ApplicationContext getInstance() {
       return INSTANCE;
    }

    public <T> T getBean(Class<T> beanClass) {
                        var objet =  beansByclass.get(beanClass);
                        return beanClass.cast(objet);
    }

}
