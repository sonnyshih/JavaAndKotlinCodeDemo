package com.sonny.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.sonny.demo.util.StringUtil;

public class HandleList1Demo {
	private static String PLATFORM_CODE = "MBLA";
	private static String SPLIT_TAG = "-_-";

	public static void main(String[] args) {

		String adobeTag = "Pers_HomeMostBrowsedByCrossSubc";
//		String adobeTag = "TestHello";
//		String adobeTag = "";
		String trackingLevel = "I";
		int baseOnItemType = 1;
		String baseOnItemTitle = "01-009-QTP";
//		int baseOnItemType = 3;
//		String baseOnItemTitle = "HelloWorld";

		List<VProductListItemInfoEntity> productDeals = generateProductDeals();

		String list1 = "";

		if (trackingLevel.equals("M")) {
			list1 = generateTrackingLevelMList1(adobeTag, trackingLevel);
			
		} else if (trackingLevel.equals("I")) {
			list1 = generateTrackingLevelIList1(adobeTag, trackingLevel,
					baseOnItemType, baseOnItemTitle, productDeals);
		}
		
		System.out.println(list1);
		
		String itemOnClickTag = generateList1ItemOnClickTag(adobeTag, baseOnItemType, baseOnItemTitle,
				1, productDeals.get(0));
		
		System.out.println(itemOnClickTag);
		
	}

	/**
	 * @param adobeTag The AdobeTag of API. 
	 * @param trackingLevel The TrackingLevel of API.
	 */
	private static String generateTrackingLevelMList1(String adobeTag,
			String trackingLevel) {
		String list1 = "";

		for (int i = 1; i <= 9; i++) {

			switch (i) {
			case 1: // {Field 1}: tab id - Sonny Shih 2016/03/23
				list1 += "" + SPLIT_TAG;
				break;

			case 2: // {Field 2}: subcategory id - Sonny Shih 2016/03/23
				list1 += "" + SPLIT_TAG;
				break;

			case 3: // {Field 3} - Sonny Shih 2016/03/23
				list1 += "" + SPLIT_TAG;
				break;

			case 4: // {Field 4}: primary item# - Sonny Shih 2016/03/23
				list1 += "" + SPLIT_TAG;
				break;

			case 5: // {Field 5} - Sonny Shih 2016/03/23
				list1 += "" + SPLIT_TAG;
				break;

			case 6: // {Field 6} - Sonny Shih 2016/03/23
				list1 += "" + SPLIT_TAG;
				break;

			case 7: // {Field 7} - Sonny Shih 2016/03/23

				String field7 = "";
				String[] adobeTagArray = adobeTag.split("_");

				if (StringUtil.isEmpty(adobeTag)) {
					field7 = PLATFORM_CODE;
				} else {
					
					if (adobeTagArray.length >= 2) {
						field7 = adobeTagArray[0] + "_" + PLATFORM_CODE
								+ adobeTagArray[1] + "_" + trackingLevel + "_"
								+ "Imp";
					} else {
						field7 = PLATFORM_CODE + "_"+adobeTag + "_" + trackingLevel + "_" + "Imp";
					}
				
				}

				list1 += field7 + SPLIT_TAG;
				break;

			case 8: // {Field 8} - Sonny Shih 2016/03/23
				list1 += "" + SPLIT_TAG;
				break;

			case 9: // {Field 9} - Sonny Shih 2016/03/23
				list1 += getUtcTime() + SPLIT_TAG;
				break;

			}
		}
		return list1;

	}

	/**
	 * @param adobeTag The AdobeTag of API. 
	 * @param trackingLevel The TrackingLevel of API.
	 * @param baseOnItemType The BaseOnItemType of API.
	 * @param baseOnItemTitle The BaseOnItemTitle of API.
	 * 
	 */
	private static String generateTrackingLevelIList1(String adobeTag,
			String trackingLevel, int baseOnItemType, String baseOnItemTitle,
			List<VProductListItemInfoEntity> productDeals) {
		String list1 = "";

		int index = 0;
		for (VProductListItemInfoEntity itemInfo : productDeals) {

			index++;

			String listItem = generateList1Item(adobeTag, trackingLevel, 
					baseOnItemType, baseOnItemTitle, index, itemInfo);
			
			if (StringUtil.isEmpty(list1)) {
				list1 = listItem;
			} else {
				list1 += "|"+listItem;
			}
		}
		return list1;

	}

	private static String generateList1Item(String adobeTag, String trackingLevel, 
			int baseOnItemType, String baseOnItemTitle, int index, VProductListItemInfoEntity itemInfo){
		
		String listItem="";
		
		for (int i = 1; i <= 9; i++) {

			switch (i) {
			case 1: // {Field 1}: tab id - Sonny Shih 2016/03/23
				listItem += "" + SPLIT_TAG;
				break;

			case 2: // {Field 2}: subcategory id - Sonny Shih 2016/03/23
				listItem += "" + SPLIT_TAG;						
				
				break;

			case 3: // {Field 3} - Sonny Shih 2016/03/23
				listItem += "" + SPLIT_TAG;
				break;

			case 4: // {Field 4}: primary item# - Sonny Shih 2016/03/23
				 if (baseOnItemType == 1 || baseOnItemType == 3) {
                     listItem += baseOnItemTitle + SPLIT_TAG;
                 } else {
                     listItem += "" + SPLIT_TAG;
                 }
				
				break;

			case 5: // {Field 5} - Sonny Shih 2016/03/23
				listItem += "" + SPLIT_TAG;
				break;

			case 6: // {Field 6} - Sonny Shih 2016/03/23
				String itemNumber = itemInfo.getItemNumber();
				String dataSourceString = itemInfo.getDataSource(); 
				
				if (!StringUtil.isEmpty(dataSourceString)) {
					listItem += itemNumber + "_" + index + "_"
							+ dataSourceString + "___" + SPLIT_TAG;
					
				} else {
					listItem += "" + SPLIT_TAG;
				}
				
				break;

			case 7: // {Field 7} - Sonny Shih 2016/03/23

				String field7 = "";
				String[] adobeTagArray = adobeTag.split("_");

				if (StringUtil.isEmpty(adobeTag)) {
					field7 = PLATFORM_CODE;
				} else {
					
					if (adobeTagArray.length >= 2) {
						field7 = adobeTagArray[0] + "_" + PLATFORM_CODE
								+ adobeTagArray[1] + "_" + trackingLevel + "_"
								+ "Imp";
					} else {
						field7 = PLATFORM_CODE + "_" + adobeTag + "_" + trackingLevel + "_"	+ "Imp";
					}
				}

				listItem += field7 + SPLIT_TAG;
				break;

			case 8: // {Field 8} - Sonny Shih 2016/03/23
				listItem += "" + SPLIT_TAG;
				break;

			case 9: // {Field 9} - Sonny Shih 2016/03/23
				listItem += getUtcTime() + SPLIT_TAG;
				break;

			}
		}
		
		return listItem;		
	}
	
	private static String generateList1ItemOnClickTag(String adobeTag, 
			int baseOnItemType, String baseOnItemTitle, int index, VProductListItemInfoEntity itemInfo){
		
		String listItem="";
		
		for (int i = 1; i <= 9; i++) {

			switch (i) {
			case 1: // {Field 1}: tab id - Sonny Shih 2016/03/23
				listItem += "" + SPLIT_TAG;
				break;

			case 2: // {Field 2}: subcategory id - Sonny Shih 2016/03/23
					listItem += "" + SPLIT_TAG;						
				break;

			case 3: // {Field 3} - Sonny Shih 2016/03/23
				listItem += "" + SPLIT_TAG;
				break;

			case 4: // {Field 4}: primary item# - Sonny Shih 2016/03/23
				 if (baseOnItemType == 1 || baseOnItemType == 3) {
                     listItem += baseOnItemTitle + SPLIT_TAG;
                 } else {
                     listItem += "" + SPLIT_TAG;
                 }
				
				break;

			case 5: // {Field 5} - Sonny Shih 2016/03/23
				listItem += "" + SPLIT_TAG;
				break;

			case 6: // {Field 6} - Sonny Shih 2016/03/23
				String itemNumber = itemInfo.getItemNumber();
				String dataSourceString = itemInfo.getDataSource(); 
				
				if (!StringUtil.isEmpty(dataSourceString)) {
					listItem += itemNumber + "_" + index + "_"
							+ dataSourceString + "___" + SPLIT_TAG;
					
				} else {
					listItem += "" + SPLIT_TAG;
				}
				
				break;

			case 7: // {Field 7} - Sonny Shih 2016/03/23

				String field7 = "";
				String[] adobeTagArray = adobeTag.split("_");

				if (StringUtil.isEmpty(adobeTag)) {
					field7 = PLATFORM_CODE;
				} else {
					if (adobeTagArray.length >= 2) {
						field7 = adobeTagArray[0] + "_" + PLATFORM_CODE
								+ adobeTagArray[1];
					} else {
						field7 = PLATFORM_CODE + "_" + adobeTag;
					}
				}
				listItem += field7 + SPLIT_TAG;
				break;

			case 8: // {Field 8} - Sonny Shih 2016/03/23
				listItem += "" + SPLIT_TAG;
				break;

			case 9: // {Field 9} - Sonny Shih 2016/03/23
				listItem += getUtcTime() + SPLIT_TAG;
				break;

			}
		}
		
		return listItem;		
	}

	
	private static String getUtcTime() {
		String dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"; // ISO-8601 format
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		String utcTime = simpleDateFormat.format(new Date());

		return utcTime;
	}

	
	
	private static List<VProductListItemInfoEntity> generateProductDeals() {
		List<VProductListItemInfoEntity> productDeals = new ArrayList<VProductListItemInfoEntity>();

		for (int i = 0; i < 5; i++) {
			VProductListItemInfoEntity product = new VProductListItemInfoEntity();

			product.setItemNumber("17-001-QTP");
			product.setDataSource("sCB");
			productDeals.add(product);
			
		}

		return productDeals;
	}

	public static class VProductListItemInfoEntity {
		public String itemNumber;
		public String dataSource;

		public String getItemNumber() {
			return itemNumber;
		}

		public void setItemNumber(String itemNumber) {
			this.itemNumber = itemNumber;
		}

		public String getDataSource() {
			return dataSource;
		}

		public void setDataSource(String dataSource) {
			this.dataSource = dataSource;
		}

	}
}
