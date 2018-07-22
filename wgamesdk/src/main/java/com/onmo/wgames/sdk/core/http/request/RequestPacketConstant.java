package com.onmo.wgames.sdk.core.http.request;

public class RequestPacketConstant {



	public interface ServiceKeys {

		public static final String SERVICE_GET_HOME = "page/";
		public static final String SERVICE_GET_CONFIG = "config";
		public static final String SERVICE_GET_CATEGORY_CONTENT = "list/ContentCarousel/";
		public static final String SERVICE_GET_GAME_CONTENT = "item/game/";
		public static final String SERVICE_GET_SEARCH_CONTENT = "search";
		public static final String SERVICE_GET_PURCHASED_GAMES_LIST = "user/locker";
		public static final String SERVICE_DELETE_PURCHASED_GAME = "user/locker/game/";
		public static final String SERVICE_GET_RECOMMENDATIONS = "user/recommendations/game/"; //type/id?
		public static final String SERVICE_GET_USER_ID = "user";
		public static final String SERVICE_GET_DOWNLOAD = "download/game/{id}?mode=UGAMEAPP&packId={packId}&USER_ID={encryptedvalue}";
		//griff
		public static final String SERVICE_GET_USER_PROFILE = "chargingprofile/view?";
		public static final String SERVICE_GET_PACK_ACTIVATE = "activatepacks/view?";
		public static final String SERVICE_GET_PACK_DEACTIVATE = "deactivatepack/view?";
		public static final String SERVICE_GET_USER = "sms/getuser";

	}


	public interface GriffRequestParam {

		public static final String APP_ID = "appid";
		public static final String MSISDN = "msisdn";
		public static final String USERNAME = "username";
		public static final String PASSWORD = "password";
		public static final String CP_NAME = "cpname";
		public static final String USER_AGENT = "useragent";
		public static final String SESSION_ID = "sessionid";
		public static final String APP_IDENTIFIER = "app_identifier";
		public static final String USER_TOKEN = "usertoken";


	}

	public interface RequestParam {

		public static final String REQUEST_SEARCH_Q = "q";
		public static final String REQUEST_OFFSET = "offset";
		public static final String MAX_RESULTS = "max";
		public static final String BROWSING_LANGUAGE = "locale";
		public static final String DEFAULT_BROWSING_LANGUAGE = "pt-br";
		public static final String IMAGE_SIZE = "imageWidth";
		public static final String LAST_UPDATED = "lastUpdated";
		public static final String REQUEST_APP_UID_HEADER = "_om_uid_";

	}


	public class DatabaseConstants {

		public static final int DATABASE_VERSION = 1;
		public static final int DATABASE_TIME_STAMP = 24 * 60 * 60 * 1000;
		public static final String DATA_TYPE_TEXT = " TEXT ";
		public static final String DATA_TYPE_INTEGER = " INTEGER ";
		public static final String QUERY_OPEN_BRACKET = "(";
		public static final String QUERY_CLOSE_BRACKET = ")";
		public static final String QUERY_COMMA = ",";

		public static final String QUERY_CREATE = "CREATE TABLE IF NOT EXISTS ";
		public static final String QUERY_DROP = "DROP TABLE IF EXISTS ";
		public static final String QUERY_SELECT_ALL = "SELECT  * FROM ";
		public static final String QUERY_UPDATE = "UPDATE ";
		public static final String QUERY_DELETE = "DELETE FROM ";
		public static final String QUERY_DELETE_CMD = "DELETE ";
	}

	public static final class VoltronConnectorConfig {

		public static final String GRIFF_USERNAME = "GRIFF_USERNAME";
		public static final String GRIFF_PASSWORD = "GRIFF_PASSWORD";

		public static final String GET_USER_TMEID_APP_IDENTIFIER = "GET_USER_TMEID_APP_IDENTIFIER";
		public static final String GET_USER_TMEID_API_SHORTCODE = "GET_USER_TMEID_API_SHORTCODE";
		public static final String GET_USER_TMEID_API_URL = "GET_USER_TMEID_API_URL";
		public static final String GET_USER_TMEID_API_PASSWORD = "GET_USER_TMEID_API_PASSWORD";
		public static final String GET_USER_TMEID_API_USERNAME = "GET_USER_TMEID_API_USERNAME";




		public static final String cpname = "cpname";
		public static final String griff_app_id = "griff_app_id";
		public static final String STORE_BASE_URL = "STORE_BASE_URL";
		public static final String ROOT_STORE_ID = "ROOT_STORE_ID";
		public static final String GRIFF_BASE_URL = "GRIFF_BASE_URL";
		public static final String STORE_LOCALE = "STORE_LOCALE";
		public static final String APP_START_API = "APP_START_API";
		public static final String ENABLE_APP_START_API = "ENABLE_APP_START_API";
		public static final String NOTIFICATION_BASE_URL = "NOTIFICATION_BASE_URL";
		public static final String ROOT_URL = "ROOT_URL";
		public static final String ROOT_PREVIEW_STORE_ID = "ROOT_PREVIEW_STORE_ID";
	}

	public static final class ConnectorConfig {

		public static final int TOP_MAX_OFFSET_LENGTH = 50;
		public static final int TOP_MAX_SIZE_UPPER_LIMIT = 100;
		public static final int SEARCH_MAX_PAGE_COUNT = 100;
		public static final int SMS_TIME_OUT_LIMIT = 45000;
		public static final int DEFAULT_TRACK_LIMIT = 10;
		public static final int DEFAULT_OFFSET_LIMIT = 0;

		public static final String ROOT_CHARTS_ID = "ROOT_CHARTS_ID";
		public static final String CHART_HOME = "CHART_HOME";
		public static final String HOME_CHART_ID = "HOME_CHART_ID";
		public static final String BASE_URL = "BASE_URL";


	}
}
