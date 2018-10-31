package com.ksa.core.bo;

/**
 * 
 * This class holds key listed in Application.properties and
 * ApplicationLocal.properties to resolve the string constants.
 * 
 * @version 1.0
 * 
 * @author Shashank Agarwal
 * @since Feb 11, 2017 2:33:27 PM
 */
public enum CorePropertiesConstants {

	CORE_PROXY_IP {
		public String getPropertyValue() {
			return "core.asynctask.ip";
		};
	},
	CORE_PROXY_PORT {
		public String getPropertyValue() {
			return "core.asynctask.port";
		};
	},
	CORE_PROXY_USERNAME {
		public String getPropertyValue() {
			return "core.asynctask.username";
		}
	},
	CORE_PROXY_PASSWORD {
		public String getPropertyValue() {
			return "core.asynctask.password";
		}
	},
	CORE_PROXY_ENABLE {
		public String getPropertyValue() {
			return "core.asynctask.proxy";
		}
	},/**
	 *Retrieves encryption key
	 */
	MCOM_ENCRYPTION_RSA_KEY {
		public String getPropertyValue() {
			return "mcom.encryption.rsakey";
		};
	},/**
	 *Retrieves encryption algorithm
	 */
	MCOM_ENCRYPTION_AES {
		public String getPropertyValue() {
			return "mcom.encryption.aes";
		};
	},/**
	 *Retrieves encryption algorithm
	 */
	MCOM_ENCRYPTION_INITVECTOR {
		public String getPropertyValue() {
			return "mcom.encryption.initvector";
		};
	},/**
	 *Retrieves encryption algorithm
	 */
	MCOM_ENCRYPTION_AES_CBS_PKCS5PADDING{
		public String getPropertyValue() {
			return "mcom.encryption.aes.cbs.pkcs5padding";
		};
	};

	public abstract String getPropertyValue();
}
