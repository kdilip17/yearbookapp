package com.example.hmspl.yearbookapp.modules.webservices;


public interface Constants {

    String APP_KEY = "app_key";


    interface AlertMessages {

        String NO_MATCH_FOUND = "No Match Found";
        String EMPTY_FIELD = "Please enter atleast one field.";

        //common messages for api failure
        String NO_INTERNET_CONNECTION = "Please check your internet connection and try again.";
        String JSON_PARSING = "Unable to send data to our server. Contact our support center.";
        String TIME_OUT = "Unable to connect to our server. Make sure you are having a stable internet connection.";
        String SERVER_CONNECTION_FAILED = "Unable to connect to our server. Make sure you are having a stable internet connection.";
        String UNABLE_TO_CONNECT_SERVER = "Unable to connect to our server. Please try again later.";
        String UPLOADED_FILE_NOT_FOUND = "Uploaded file is not found on the SD card";
        String AUTHORIZATION_FAILED = "Authorization failed";
        String UNKOWN_ERROR = "Internal error occurred. Try again later";
    }

    interface ApiKeys {

        int LIST_LIMIT = 15;
        int SEARCH_LIST_LIMIT = 25;
        int PAGE_COUNT = 10;
        String IMAGE_UPLOAD = "file";
        String MESSAGE = "message";
        String ERROR = "msg";
        String MODULE = "module";
        String TO = "to";
        String USER_ID = "user_id";
        String KLIENT_ID = "klient_id";
        String CATEGORY = "category";
        String EMAIL = "email";
        String PAGE = "page";
        String BRANCH_ID = "branch_id";
        String TEAM_ID = "team_id";
        String STAFF_ID = "staff_id";
        String LAST_ORDERED_BY = "last_ordered_date";
        String LAST_ORDERED_DATE = "last_ordered_by";
        String COMMENTS = "comments";
        String PRODUCT = "product";
        String PURCHASE_TYPE = "purchase_type";
        String COUNT = "count";
        String DATE = "date";
        String START_TIME = "start_time";
        String FROM_DATE = "from_date";
        String TO_DATE = "to_date";
        String FROM_TIME = "from_time";
        String TO_TIME = "to_time";
        String TOURPLAN_ID = "tourenplan_id";
        String TOURPLAN_TYPE = "tourenplan_type";
        String REPORT_TYPE = "report_type";
        String REPORT_TYPES[] = {"daily", "wund"};
        String ID = "id";
        String STATUS = "status";
        String SUCCESS = "success";
        String[] DAILY_PLAN_TYPE = {"client", "car", "other", "interval"};
        String[] ORDER_STATUS = {"received", "canceled"};
        String ORDER_ID = "order_id";
        String TYPE = "type";
        String PRODUCT_ID = "product_id";
        String[] ORDER_TYPE = {"order", "product"};
        String[] DYNAMIC_CONTENT_MODULE_TYPE = {"order", "wund"};
        String[] MESSAGE_TYPE = {"All", "Team"};
        String END_TIME = "end_time";
        String HOME = "home";
        String NURSING_PROCESS = "pflegeprozess";
        String BLOOD_PRESSURE_MM = "blood_pressure_mm";
        String BLOOD_PRESSURE_HG = "blood_pressure_hg";
        String BLOOD_SUGAR = "blood_sugar";
        String PULSE = "plus";
        String WEIGHT = "weight";
        String TEMPERATURE = "temperature";
        String PRIVATE = "private";
        String PUBLIC = "public";
        String CATEGORIES = "categories";
        String WUND_ID = "wund_id";
        String ACTIVE = "active";
        String INACTIVE = "inactive";
        String LISTUNG = "leistung";
        String SHIFT = "night_shift";
        String STATUS_CODE = "STATUS_CODE";
        String REG_TIME = "regtime";
        String ORDER = "order";
    }

    interface AppKeys {
        String EXTERNAL_FOLDER_NAME = "Spitex";
        String AUTHORIZATION = "authorization";
        String ID = "id";
        String MB_NO = "mbNo";
        String DEVICE_MODE = "ANDROID";
        String FILE_PROVIDER_AUTHORITY = "in.spitex.fileprovider";
        String GOOGLE_API_KEY = "";
    }

    interface BroadcastKeys {
        String UNAUTHORIZED = "in.gamesho.UNAUTHORIZED";
        String MESSAGE = "message";
    }


    interface Dateformat_As_UX {
        String TIME_ZONE_GMT = "GMT";
        String INDIA_TIMEZONE = "GMT+05:30";
        String BASIC_FORMAT = "dd.MM.yyyy";
        String TIME_FORMAT = "HH.mm";
        String HH_COLON_MM = "HH:mm";
        String TIME_AM_PM_FORMAT = "hh:mm a";
        String DD_MM_YYYY_HIFFEN_HH_MM = "dd.MM.yyyy | HH.mm";
        String DD_MM_YYYY_HH_MM = "dd.MM.yyyy HH.mm";
        String SERVER_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
        String TIMER_TIME_FORMAT = "HH:mm:ss";
        String TIMER_FORMAT = "hh:mm:ss a";
        String DD_MMM_YYYY = "dd MMM yyyy";
        String MMMM = "MMMM";
        String MMM_YYYY = "MMM - yyyy";
        String DATE_FORMAT = "EEE, MMM dd yyyy";
        String SERVER_DATE_FORMAT = "dd.MM.yyyy HH:mm:ss";
        String SERVER_TIME_ZONE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
    }

    interface ErrorCodes {
        //custom error codes for internal data handling
        int ERROR = 1443;
        int SCHEDULE_NOT_AVAILABLE = 420;
        int DATA_NOT_FOUND = 1444;
        int JSON_PARSING = 1445;
        int SERVICE_UNAVAILABLE = 1447;
        int SERVER_CONNECTION_FAILED = 1448;

        int TIME_OUT = 1449;
        int SERVER_LOOP_ERROR_OCCURED = 408;
        //defined error codes from api
        int SESSION_EXPIRED_1 = 401;
        int SESSION_EXPIRED_2 = 402;
        int API_CALL_MANUALY_CANCELED = -1;

    }

    interface FragmentTags {

        String HOME = "_home";
    }

    interface SharedKeys {
        String AUTH_KEY = "authKey";
        String IS_LOGGEDIN = "IS_LOGGEDIN";
        String USER_ID = "user_id";
        String LANGUAGE = "LANGUAGE";
        String GENERAL_ORDER = "GENERAL_ORDER";
        String GENERAL_BRANCH = "GENERAL_BRANCH";
        String USER = "user";
        String GENERAL_DAILY_CATEGORY = "GENERAL_DAILY_CATEGORY";
        String GENERAL_WUND_CATEGORY = "GENERAL_WUND_CATEGORY";
        String MEDICINE = "Medicine";
    }

    interface NavigationMenuIds {
        int HOME = 0;
        int CHAT = 1;
        int NOTIFICATION=2;
        int REMINDER=3;
        int LOGOUT = 4;
    }

    interface MenuIds {
        String CLIENTS = "1";
        String STAFFS = "2";
        String PLANNING = "3";
        String NURSING_PROCESS = "4";
        String ACTION_PLANNING = "5";
        String NURSING_REPORT = "6";
        String MEDICINE_MANAGEMENT = "7";
        String WOUND_REPORT = "8";
        String VITAL_VALUES = "9";
        String MEDICINE = "10";
    }

    interface MedicineTime {
        int MORNING = 0;
        int LUNCH = 1;
        int NOON = 2;
        int EVNING = 3;
        int NIGHT = 4;
    }

    interface CommonFields {
        String LANGUAGE_TEXT = "{\"status\":\"Success\",\"language\":{\"login\":{\"user_id\":\"Personal Nr.\",\"password\":\"Passwort\",\"forgot_password\":\"Passwort Vergessen?\",\"sign_in\":\"Anmelden\",\"logout_confirmation\":\"Wollen Sie sich abmelden ?\",\"emptyPassword\":\"Kennwort ist leer\",\"emptyUserId\":\"Benutzer-ID ist leer\",\"loginFailure\":\"Ung\\u00fcltige Anmeldeinformation\",\"noNetwork\":\"Bitte \\u00fcberpr\\u00fcfen Sie Ihre Netzwerkverbindung.\",\"closeAddReportPopup\":\"Sind Sie sicher, das Report-Popup zu schlie\\u00dfen?\",\"logout\":\"Ausloggen\",\"ok\":\"OK\",\"cancel\":\"Abbrechen\",\"done\":\"Fertig\"},\"forgot_password\":{\"email_id\":\"E-Mail Adresse\",\"register_email_id\":\"Geben Sie Ihre registrierte E-Mail ein\",\"reset_password\":\"Password zur\\u00fccksetzen\",\"forgot_password\":\"Passwort Vergessen?\",\"emptyEmailId\":\"E-Mail-ID ist leer\",\"invalidEmailId\":\"Ung\\u00fcltige E-Mail\"},\"home\":{\"home\":\"Home\"},\"client\":{\"patient\":\"Klient\",\"dob\":\"Geb.\",\"age\":\"Alter\",\"patient_id\":\"Klient-Nr.\",\"cancel\":\"Abbrechen\",\"insurance\":\"Versicherung\",\"contact_person\":\"Bezugsperson\",\"diagnose\":\"Diagnose\",\"doctor\":\"Arzt\",\"house_key_info\":\"Schl\\u00fcssel Info\",\"insurance_name\":\"Name\",\"insurance_number\":\"Versicherungsnummer\",\"insurance_class\":\"Klasse\",\"client_living_will\":\"Patientenverf\\u00fcgung\",\"main_insurance\":\"Krankenkasse\",\"sub_insurance\":\"Zusatzversicherung\",\"client_will\":\"Patientenverf\\u00fcgung\",\"client_power_of_attorney\":\"Vorsorgevollmacht\",\"care_taker\":\"Bezugsperson\",\"family_doctor\":\"Hausarzt\",\"special_doctor\":\"Spezialarzt\",\"choose_client\":\"W\\u00e4hle ein Klientt\",\"key_code\":\"Code\",\"key_number\":\"Nummer\",\"key_location\":\"Ort\",\"clientListEmpty\":\"Keine Klienten vorhanden\",\"clientDetailsEmpty\":\"Es sind keine Klientendetails vorhanden\",\"clientSearch\":\"Es gibt keine Klienten  \",\"ahv_nr\":\"AHV Nr.\"},\"staff\":{\"staff\":\"Mitarbeiter\",\"staff_id\":\"Personal-Nr.\",\"qualification\":\"Qualifikation\",\"function\":\"Funktion\",\"staffDetailsEmpty\":\"Es sind keine Mitarbeiter vorhanden\",\"staffListEmpty\":\"Keine Mitarbeiter vorhanden\",\"staffSearch\":\"Es gibt keine Mitarbeiter\"},\"planning\":{\"today\":\"Heute\",\"filter\":\"Verlauf \",\"from_date\":\"Von\",\"to_date\":\"Bis\",\"search\":\"Suche\",\"reset\":\"Zur\\u00fccksetzen\",\"planning\":\"Planung\",\"monthly_plan\":\"Dienstplanung\",\"daily_plan\":\"Tourenplan\",\"total_time\":\"Totale Arbeitzeit\",\"notes\":\"Notizen\",\"staff_notes\":\"Mitarbeiter Info.\",\"client_notes\":\"Klient Info.\",\"travelling_time\":\"Fahrzeiten\",\"service\":\"Leistungen\",\"house_key_info\":\"Schl\\u00fcssel Info\",\"client_info\":\"Klient Info\",\"key_number\":\"Nummer\",\"key_code\":\"Code\",\"key_location\":\"Ort\",\"monday\":\"Montag\",\"tuesday\":\"Dienstag\",\"wednesday\":\"Mittwoch\",\"thursday\":\"Donnerstag\",\"friday\":\"Freitag\",\"saturday\":\"Samstag\",\"sunday\":\"Sonntag\",\"hours\":\"Std.\",\"minutes\":\"Min.\",\"noPlanToday\":\"Es gibt heute keine Touren\",\"planFilterEmpty\":\"Es gibt keine Tourenplanliste\",\"intervell\":\"Pause\",\"dailyPlanEmpty\":\"Es gibt heute keine Touren\",\"monthlyPlanFilterEmpty\":\"Es gibt keine Schichten f\\u00fcr den gegebenen Filter\",\"monthlyPlanEmpty\":\"Es gibt keine Schichten\",\"night_shift\":\"Night shift\",\"day_shift\":\"Day shift\",\"category\":\"Kat.\",\"eg\":\"eg : 120\",\"address\":\"Adresse\",\"service_name\":\"Leistungen\",\"service_submit_confirmation\":\"Sind Sie sicher?\",\"duration\":\"Dauer\",\"service_duration_exceeds_validation\":\"The minutes added exceeeds the duration.\",\"service_duration_lesser_validation\":\"The minutes added was less than the duration.\",\"planServiceValidation\":\"Please complete the performance report.\",\"planReportValidation\":\"Please complete the daily report.\"},\"nursing_process\":{\"comment\":\"Bemerkung\",\"show_only\":\"Nur Lesen\",\"add_new\":\"Neu Einf\\u00fcgen\",\"nursing_process\":\"Pflegeprozess\"},\"message_board\":{\"team\":\"Team\",\"inbox\":\"Posteingang\",\"sent\":\"Gesendet\",\"comment\":\"Bemerkung\",\"all\":\"Alle\",\"branch\":\"Filiale\",\"staff\":\"Mitarbeiter\",\"add_new\":\"Neu Einf\\u00fcgen\",\"message\":\"\\u00dcbergabebuch\",\"inboxEmpty\":\"Es gibt keine Nachrichten in Ihrem Posteingang\",\"postMsgEmpty\":\"Wollen Sie Nchrichten senden\",\"submited_successfully\":\"Erfolgreich Eingef\\u00fcgt\"},\"action_planning\":{\"action_palnning\":\"Massnahmen Planung\",\"access_to_site\":\"Zugang zum Einsatzort\",\"access_by_car\":\"Zufahrt mit dem Auto m\\u00f6glich? \",\"public_transport\":\"\\u00d6ffentliches Verkehrsmittel in 5 Minuten erreichbar?\",\"directions\":\"Wegbeschreibung \\/ Parkierm\\u00f6glichkeit\",\"individual_clarification\":\"Individuelle Pr\\u00e4zisierungen\",\"current_diagnose\":\"Gegenw\\u00e4rtige pflege- und betreuungsrelevante Diagnosen\",\"diagnose\":\"Diagnosen\",\"routine\":\"Tagesablauf\",\"monday\":\"Mo.\",\"tuesday\":\"Di.\",\"thursday\":\"Do.\",\"wednesday\":\"Mi.\",\"friday\":\"Fr.\",\"saturday\":\"Sa.\",\"sunday\":\"So.\",\"service\":\"Leistung\",\"action\":\"Prophylaxe\"},\"nursing_report\":{\"daily_report\":\"Pflegebericht\",\"add_new\":\"Neu Einf\\u00fcgen\",\"categorie\":\"AEDL\",\"sub_categorie\":\"Verlaufsbericht\",\"private\":\"Gesch\\u00fctzt\",\"comment\":\"Erg\\u00e4nzung\",\"filter\":\"Verlauf\",\"from_date\":\"Von\",\"to_date\":\"Bis\",\"search\":\"Suche\",\"reset\":\"Zur\\u00fccksetzen\",\"dailyReportEmpty\":\"Es sind keine Berichte verf\\u00fcgbar\",\"dailyReportEmptyFilter\":\"Es sind keine Berichte verf\\u00fcgbar\",\"noCategory\":\"W\\u00e4hle\\u00a0eine Kategorie\",\"noSubCategory\":\"W\\u00e4hle eine Unterkategorie\",\"submited_successfully\":\"Erfolgreich Eingef\\u00fcgt\",\"select_category\":\"Please select category.\"},\"wund_report\":{\"wund_daily_report\":\"Wunddokumentation\",\"add_new\":\"Neu Einf\\u00fcgen\",\"categorie\":\"Wundlokalisation\",\"sub_categorie\":\"Verlaufsbericht\",\"private\":\"Gesch\\u00fctzt\",\"comment\":\"Erg\\u00e4nzung\",\"filter\":\"Verlauf\",\"from_date\":\"Von\",\"to_date\":\"Bis\",\"search\":\"Suche\",\"reset\":\"Zur\\u00fccksetzen\",\"wund\":\"Wund\",\"wundListEmpty\":\"Es sind keine Wund-Berichte verf\\u00fcgbar\",\"noCategory\":\"W\\u00e4hle\\u00a0eine Kategorie\",\"wundReportEmptyFilter\":\"Es sind keine Wund-Berichte verf\\u00fcgbar\",\"noSubCategory\":\"W\\u00e4hle eine Unterkategorie\",\"submited_successfully\":\"Erfolgreich Eingef\\u00fcgt\",\"chart\":\"Location Chart\",\"select_wund\":\"Select Wund\"},\"vital_value\":{\"vital_value\":\"Vitalwerte\",\"blodd_pressure\":\"Blutdruck (mmHg)\",\"pulse\":\"Plus (Schl\\u00e4ge\\/Minute)\",\"temperature\":\"Temperatur (\\u00b0C)\",\"blood_sugar\":\"Blutzucker (mmol)\",\"weight\":\"Gewicht (kg)\",\"comment\":\"Bemerkung\",\"add_new\":\"Neu Einf\\u00fcgen\",\"from_date\":\"Von\",\"to_date\":\"bis\",\"from_time\":\"Uhrzeit von\",\"to_time\":\"Uhrzeit bis\",\"serach\":\"Suche\",\"filter\":\"Verlauf\",\"reset\":\"Zur\\u00fccksetzen\",\"vitelListEmpty\":\"Es sind keine Vital-Berichte verf\\u00fcgbar\",\"vitelReportEmptyFilter\":\"Es sind keine Vital-Berichte verf\\u00fcgbar\",\"vital_validation\":\"Enter atleast one information.\",\"vitalTimeValidation\":\"Fill the appropriate start and end time\"},\"order\":{\"order\":\"Bestellungen\",\"category\":\"Kategorie\",\"purchase_type\":\"Type\",\"product\":\"Artikel\",\"count\":\"Menge\",\"status\":\"Status\",\"order_from\":\"Bestellung vom\",\"ordered_by\":\"Erledigt\",\"last_ordered_by\":\"Letzte Ausf\\u00fchrung\",\"ordered_date\":\"Bestelldatum\",\"comments\":\"Bemerkung\",\"add_new\":\"Neu Einf\\u00fcgen\",\"order_number\":\"Bestell Nr.\",\"orderEmpty\":\"Keine Bestellungen vorhanden\",\"categoryEmpty\":\"W\\u00e4hle\\u00a0eine Kategorie\",\"itemsEmpty\":\"W\\u00e4hle einen Artikel\",\"typeEmpty\":\"W\\u00e4hle einen Artikel\",\"countEmpty\":\"Geben Sie die Anzahl ein\",\"changeStatus\":\"Ihr Bestellstatus wurde ge\\u00e4ndert\",\"cancelOrder\":\"M\\u00f6chten Sie die Bestellung stornieren?\",\"date\":\"Datum\",\"name\":\"Name\",\"canceled\":\"Abgebrochen\",\"processed\":\"Verarbeitet\",\"ordered\":\"Bestellt\",\"delivered\":\"Ausgeliefert\",\"order_submit_confirmation\":\"Sind Sie sicher?\"},\"medicine_management\":{\"medicine_management\":\"Medikamenten Verwaltung\",\"morning\":\"MO\",\"lunch\":\"MI\",\"noon\":\"NM\",\"evening\":\"AB\",\"night\":\"NA\",\"filter\":\"Verlauf\",\"search\":\"Suche\",\"active\":\"Aktuell\",\"inactive\":\"Gestoppt\",\"comment\":\"Bemerkung\",\"reset\":\"Zur\\u00fccksetzen\",\"prescirbed_date\":\"Verordnungsdatum\",\"changed_by\":\"ge\\u00e4ndert am\",\"injektion\":\"Injektionen\\/Infusionen \",\"medication\":\"Bedarfsmedikamente \",\"short_medication\":\"Kurzmedikation mit Applikationsform \",\"drugs\":\"Medikamente\",\"injection_type\":\"Form\",\"drugsEmpty\":\"No drugs found.\"},\"general\":{\"added_successfully\":\"Added Successfully\",\"february\":\"Februar\",\"march\":\"Marz\",\"april\":\"April\",\"may\":\"Mai\",\"june\":\"Juni\",\"july\":\"Juli\",\"august\":\"August\",\"september\":\"September\",\"october\":\"Oktober\",\"november\":\"November\",\"december\":\"Dezember\",\"sunday\":\"Sonntag\",\"monday\":\"Montag\",\"tuesday\":\"Dienstag\",\"wednesday\":\"Mittwoch\",\"thursday\":\"Donnerstag\",\"friday\":\"Freitag\",\"saturday\":\"Samstag\"}}}";
    }

    interface DetailListViewType {

        int INSURENCE = 0;
        int LIVING_WILL = 1;
        int CONTACT_PERSON = 2;
        int DIAGNOSE = 3;
        int DOCTOR = 4;
        int STAFF_DETAIL = 5;
    }
}
