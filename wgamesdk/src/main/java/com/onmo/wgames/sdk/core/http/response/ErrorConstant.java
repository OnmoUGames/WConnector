package com.onmo.wgames.sdk.core.http.response;

/**
 * Created by Srini on 15/02/2018.
 * Comment
 */

public class ErrorConstant {



	public final class ErrorCode {



		public static final int HTTP_RESPONSE_EXCEPTION 	= 4004;
		public static final int NO_CONTENT_AVAILABLE 		= 4010;

		public static final int USER_CANNOT_REGISTER 		= 4011;
		public static final int USER_CANNOT_UPDATED_SUBSCRIPTION 		= 4012;

		public static final int SDK_NOT_INITIALIZED 		= 1001;

		public static final int USER_NOT_SUBSCRIBE 			= 3000;
		public static final int TOKEN_EXPIRED 				= 3001;

		public static final int CONNECTION_ERROR 			= 4000;
		public static final int ERROR 						= 4001;
		public static final int GENERAL_ERROR				= 4002;

		public static final int INVALID_OPERATOR 			= 4100;

		public static final int INVALID_PHONE_NUMBER 		= 4200;
		public static final int INVALID_OTP 				= 4201;
		public static final int INVALID_SESSION 			= 4203;

		public static final int INVALID_CONTENT_ID 			= 4205;
		public static final int INVALID_CLIP_ID 			= 4208;
		public static final int INVALID_SEARCH_KEY 			= 4209;
		public static final int NO_CACHE_CONTENT_AVAILABLE 		= 4300;
		public static final int NO_CONTENT_UPDATE_AVAILABLE = 4211;
		public static final int CONTENT_SELECTION_NOT_SUPPORTED = 4212;
		public static final int CACHE_EMPTY	 				= 4213;
		public static final int ACTIVATION_SUPPORTED_SELECTION_NOT_SUPPORTED = 4214;
		public static final int EPHEMERAL_NOT_SUPPORTED = 4215;
		public static final int NO_MORE_CREDIT = 4216;

		public static final int TRACK_IS_ALREADY_DEFAULT 	= 5003;
		public static final int TRACK_NOT_FOUND 			= 5004;

		public static final int SMP_SERVER_DOWN 		= 9000;
	}

	public static String getString(int index)

	{

		switch (index) {
			case (ErrorCode.HTTP_RESPONSE_EXCEPTION):
				return "HTTP_RESPONSE_EXCEPTION";
			case (ErrorCode.NO_CONTENT_AVAILABLE):
				return "NO_CONTENT_AVAILABLE";
			case (ErrorCode.USER_CANNOT_REGISTER):
				return "USER_CANNOT_REGISTER";
			case (ErrorCode.USER_CANNOT_UPDATED_SUBSCRIPTION):
				return "USER_CANNOT_UPDATED_SUBSCRIPTION";
			case (ErrorCode.SDK_NOT_INITIALIZED):
				return "SDK_NOT_INITIALIZED";

			default:
				return "DEFAULT ERROR";
		}
	}
}
