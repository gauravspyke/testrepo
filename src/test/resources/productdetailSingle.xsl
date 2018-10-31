<!--
© Inter IKEA Systems B.V. 2015
-->

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
	xmlns:ns="ikea.com/cem/iows/RetailItemCommunicationService/2.0/" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" >
	<xsl:output method="text" />
    
    	<xsl:template match="/ns:RetailItemComm">
		{
		"ItemNo": "<xsl:value-of select="ItemNo" />",
		"ItemNoGlobal": "<xsl:value-of select="ItemNoGlobal" />",
		"ItemType": "<xsl:value-of select="ItemType" />",
		"NewsType": "<xsl:value-of select="NewsType" />",
		"ProductName": "<xsl:value-of select="ProductName" />",
		"ProductTypeName": "<xsl:value-of select="ProductTypeName" />",
		"ValidDesignText": "<xsl:value-of select="ValidDesignText" />",
		"OnlineSellable": "<xsl:value-of select="OnlineSellable" />",
		"BreathTakingItem": "<xsl:value-of select="BreathTakingItem" />",
		"ItemUnitCode": "<xsl:value-of select="ItemUnitCode" />",
		"ItemNumberOfPackages": "<xsl:value-of select="ItemNumberOfPackages" />",
		"AssemblyCode": "<xsl:value-of select="AssemblyCode" />",
		"DesignerNameComm": "<xsl:value-of select="DesignerNameComm" />",
		"PriceUnitTextMetric": "<xsl:value-of select="PriceUnitTextMetric" />",
		"PriceUnitTextImperial": "<xsl:value-of select="PriceUnitTextImperial" />",
		"ItemPriceUnitFactorMetric": "<xsl:value-of select="ItemPriceUnitFactorMetric" />",
		"ItemPriceUnitFactorImperial": "<xsl:value-of select="ItemPriceUnitFactorImperial" />",
		"PresentationGroupCodeEn": "<xsl:value-of select="PresentationGroupCodeEn" />",
		"UnitPriceGroupCode": "<xsl:value-of select="UnitPriceGroupCode" />",
		"GlobalisationContext":{
		"LanguageCodeIso": "<xsl:value-of select="GlobalisationContext/LanguageCodeIso" />",
		"CountryCodeIso": "<xsl:value-of select="GlobalisationContext/CountryCodeIso" />"
		},
		
		<xsl:for-each select="CatalogRefList/CatalogRef">
		<xsl:if test="Catalog/CatalogId = 'genericproducts'">
			"GPRItemOrigin": "<xsl:value-of select="CatalogElementList/CatalogElement/CatalogElementId" />",
		</xsl:if>
		</xsl:for-each>
		
		"RetailItemCareInstructionList":{
   "RetailItemCareInstruction":
   [
   <xsl:for-each select="RetailItemCareInstructionList/RetailItemCareInstruction">{
   "SortNo": "<xsl:value-of select="SortNo"/>",
   "CareInstructionHeader": "<xsl:value-of select="CareInstructionHeader" />",
   "ProductTypeText": "<xsl:value-of select="ProductTypeText" />",
   "RetailItemCareInstructionTextList":{
   "RetailItemCareInstructionText":[
   <xsl:for-each select="RetailItemCareInstructionTextList/RetailItemCareInstructionText">{
   "CareInstructionText": "<xsl:value-of select="CareInstructionText" />",
   "SortNo": "<xsl:value-of select="SortNo" />"
   }
   <xsl:if test="position() != last()">,</xsl:if>  
   </xsl:for-each>
   ]
   }
   }
   <xsl:if test="position() != last()">,</xsl:if>  
   </xsl:for-each>
   ]
  },
		
		"ClassUnitKey":{
			"ClassType": "<xsl:value-of select="ClassUnitKey/ClassType" />",
			"ClassUnitType": "<xsl:value-of select="ClassUnitKey/ClassUnitType" />",
			"ClassUnitCode": "<xsl:value-of select="ClassUnitKey/ClassUnitCode" />"
		},
		
		"RetailItemCommPriceList":{
			"RetailItemCommPrice":[
			<xsl:for-each select="RetailItemCommPriceList/RetailItemCommPrice">{
				"RetailPriceType": "<xsl:value-of select="RetailPriceType" />",
				"Price": "<xsl:value-of select="Price" />",
				"PriceExclTax": "<xsl:value-of select="PriceExclTax" />",
				"CurrencyCode": "<xsl:value-of select="CurrencyCode" />",
				"ValidFromDateTime": "<xsl:value-of select="ValidFromDateTime" />",
				"ValidToDateTime": "<xsl:value-of select="ValidToDateTime" />",
				"ReasonCode": "<xsl:value-of select="ReasonCode" />",
				"ComparableUnitPrice":{
				"UnitPriceMetric": "<xsl:value-of select="ComparableUnitPrice/UnitPriceMetric" />",
				"UnitPriceMetricExclTax": "<xsl:value-of select="ComparableUnitPrice/UnitPriceMetricExclTax" />",
				"UnitPriceImperial": "<xsl:value-of select="ComparableUnitPrice/UnitPriceImperial" />",
				"UnitPriceImperialExclTax": "<xsl:value-of select="ComparableUnitPrice/UnitPriceImperialExclTax" />"			
				}
			}
			<xsl:if test="position() != last()">,</xsl:if>		
			</xsl:for-each>
			]
		},
			
		"GPRCommSelectionCriteriaSelectionList":{
		"GPRCommSelectionCriteriaSelection":[
		<xsl:for-each select="GPRCommSelectionCriteriaSelectionList/GPRCommSelectionCriteriaSelection">
		{
			"SelectionCriteriaCode": "<xsl:value-of select="SelectionCriteriaCode" />",
			"SelectionCriteriaName": "<xsl:value-of select="SelectionCriteriaName" />",
			"SelectionCriteriaValue": "<xsl:value-of select="SelectionCriteriaValue" />"
		}
		<xsl:if test="position() != last()">,</xsl:if>		
		</xsl:for-each>
		]},
		
		"AttributeGroupList":{
		"AttributeGroup":[
		<xsl:for-each select="AttributeGroupList/AttributeGroup">
		{
			"GroupName": "<xsl:value-of select="GroupName" />",
			"AttributeList":{
			"Attribute":[ 
			<xsl:for-each select="AttributeList/Attribute">
			{
				"Name": "<xsl:value-of select="Name" />",
				"Value": "<xsl:value-of select="Value" />"
			}
			<xsl:if test="position() != last()">,</xsl:if>		
			</xsl:for-each>
			]}
		}
		<xsl:if test="position() != last()">,</xsl:if>		
		</xsl:for-each>
		]},
		
		"ItemMeasureReferenceTextMetric": "<xsl:value-of select="ItemMeasureReferenceTextMetric" />",
		"ItemMeasureReferenceTextImperial": "<xsl:value-of select="ItemMeasureReferenceTextImperial" />",
		"RetailItemCustomerBenefitList":{
		"RetailItemCustomerBenefit": [
		<xsl:for-each select="RetailItemCustomerBenefitList/RetailItemCustomerBenefit">
		{
		"CustomerBenefitText": "<xsl:value-of select="CustomerBenefitText"/>",
		"SortNo": "<xsl:value-of select="SortNo"/>"
		}
		<xsl:if test="position() != last()">,</xsl:if>		
		</xsl:for-each>
		]
		},
				
		"RetailItemCustomerMaterialList":{
			"RetailItemCustomerMaterial":[
			<xsl:for-each select="RetailItemCustomerMaterialList/RetailItemCustomerMaterial">{
			"ProductTypeText": "<xsl:value-of select="ProductTypeText" />",
			"RetailItemPartMaterialList":{
			"RetailItemPartMaterial":[
			<xsl:for-each select="RetailItemPartMaterialList/RetailItemPartMaterial">{
			"MaterialText": "<xsl:value-of select="MaterialText" />",
			"PartText": "<xsl:value-of select="PartText" />",
			"SortNo": "<xsl:value-of select="SortNo" />"
			}
			<xsl:if test="position() != last()">,</xsl:if>		
			</xsl:for-each>
			]
			},
			"SortNo": "<xsl:value-of select="RetailItemCustomerMaterialList/RetailItemCustomerMaterial/SortNo" />"
			}
			<xsl:if test="position() != last()">,</xsl:if>		
			</xsl:for-each>
			]
		},
		
		"RetailItemLongBenefitList":{
			"RetailItemLongBenefit":[
			<xsl:for-each select="RetailItemLongBenefitList/RetailItemLongBenefit">{
			"LongBenefitSubject": "<xsl:value-of select="LongBenefitSubject" />",
			"LongBenefitHeader": "<xsl:value-of select="LongBenefitHeader" />",
			"LongBenefitName": "<xsl:value-of select="LongBenefitName" />",
			"LongBenefitText": "<xsl:value-of select="LongBenefitText" />"
			}
			<xsl:if test="position() != last()">,</xsl:if>		
			</xsl:for-each>
			]
		},
				
		"RetailItemGoodToKnowList":{
			"RetailItemGoodToKnow":[
			<xsl:for-each select="RetailItemGoodToKnowList/RetailItemGoodToKnow">{
			"GoodToKnowTypeNameEn": "<xsl:value-of select="GoodToKnowTypeNameEn" />",
			"GoodToKnowText": "<xsl:value-of select="GoodToKnowText" />",
			"SortNo": "<xsl:value-of select="SortNo" />"
			}
			<xsl:if test="position() != last()">,</xsl:if>		
			</xsl:for-each>
			]
		},
		
		"RetailItemCustomerEnvironmentList":{
			"RetailItemCustomerEnvironment":{
			"RetailItemEnvironmentTextList":[
			<xsl:for-each select="RetailItemCustomerEnvironmentList/RetailItemCustomerEnvironment/RetailItemEnvironmentTextList/RetailItemEnvironmentText">{
			"EnvironmentText": "<xsl:value-of select="EnvironmentText" />",
			"SortNo": "<xsl:value-of select="SortNo" />"
			}
			<xsl:if test="position() != last()">,</xsl:if>		
			</xsl:for-each>
			],
			"SortNo": "<xsl:value-of select="RetailItemCustomerMaterialList/RetailItemCustomerMaterial/SortNo" />"
			}
		},
			
		"RetailItemCommPackageMeasureList":{
		"RetailItemCommPackageMeasure": [
		<xsl:for-each select="RetailItemCommPackageMeasureList/RetailItemCommPackageMeasure">
		{
		"PackageMeasureTextImperial": "<xsl:value-of select="PackageMeasureTextImperial"/>",
		"PackageMeasureTextMetric": "<xsl:value-of select="PackageMeasureTextMetric"/>",
		"PackageMeasureType": "<xsl:value-of select="PackageMeasureType"/>",
		"ConsumerPackNumber": "<xsl:value-of select="ConsumerPackNumber"/>",
		"SortNo": "<xsl:value-of select="SortNo"/>"
		}
		<xsl:if test="position() != last()">,</xsl:if>		
		</xsl:for-each>
		]
		},
		
		"RetailItemCommMeasureList":{
		"RetailItemCommMeasure": [
		<xsl:for-each select="RetailItemCommMeasureList/RetailItemCommMeasure">
		{
		"ItemMeasureTextImperial": "<xsl:value-of select="ItemMeasureTextImperial"/>",
		"ItemMeasureTextMetric": "<xsl:value-of select="ItemMeasureTextMetric"/>",
		"ItemMeasureTypeName": "<xsl:value-of select="ItemMeasureTypeName"/>",
		"SortNo": "<xsl:value-of select="SortNo"/>"
		}
		<xsl:if test="position() != last()">,</xsl:if>		
		</xsl:for-each>
		]
		},
		<xsl:if test="ItemType = 'SPR'">
    "RetailItemCommChildList":{
      "RetailItemCommChild": [
        <xsl:for-each select="RetailItemCommChildList/RetailItemCommChild">
        {
          "Quantity":"<xsl:value-of select="Quantity"/>", 
          "ItemNo":"<xsl:value-of select="ItemNo"/>",
          "ItemType":"<xsl:value-of select="ItemType"/>",
          "ProductName":"<xsl:value-of select="ProductName"/>",
          "ProductTypeName":"<xsl:value-of select="ProductTypeName"/>",
           "Aisle":"N/A",
            "Location":"N/A",
          "ItemNumberOfPackages":"<xsl:value-of select="ItemNumberOfPackages"/>",
          "RetailItemCommPackageMeasureList":{
            "RetailItemCommPackageMeasure": [
              <xsl:for-each select="RetailItemCommPackageMeasureList/RetailItemCommPackageMeasure">
              {
                "PackageMeasureType":"<xsl:value-of select="PackageMeasureType"/>",
                "PackageMeasureTextMetric":"<xsl:value-of select="PackageMeasureTextMetric"/>",
                "PackageMeasureTextImperial":"<xsl:value-of select="PackageMeasureTextImperial"/>",
                "ConsumerPackNumber": "<xsl:value-of select="ConsumerPackNumber"/>",
                "SortNo":"<xsl:value-of select="SortNo"/>"
              }
    	        <xsl:if test="position() != last()">,</xsl:if>		
              </xsl:for-each>
            ]
          },
          
          
          "RetailItemCommAttachmentList":{
            "RetailItemCommAttachment": [
              <xsl:for-each select="RetailItemCommAttachmentList/RetailItemCommAttachment">
              {
                "AttachmentType":"<xsl:value-of select="AttachmentType"/>",
                "AttachmentUrl":"<xsl:value-of select="AttachmentUrl"/>",
                "SortNo":"<xsl:value-of select="SortNo"/>"
              }
    	        <xsl:if test="position() != last()">,</xsl:if>		
              </xsl:for-each>
            ]
          }
          
         }
		  	<xsl:if test="position() != last()">,</xsl:if>		
	  	</xsl:for-each>
      ]
    },
     </xsl:if>
     "RetailItemFeeList":{
      "RetailItemFee": [
        <xsl:for-each select="RetailItemFeeList/RetailItemFee">
        {
          "FeeType":"<xsl:value-of select="FeeType"/>", 
          "FeeAmount":"<xsl:value-of select="FeeAmount"/>",
          "CurrencyCode":"<xsl:value-of select="CurrencyCode"/>"
         }
		  	<xsl:if test="position() != last()">,</xsl:if>		
	  	</xsl:for-each>
      ]
    },
   
     "RetailItemTechnicalInformationGroupList":{
      "RetailItemTechnicalInformationGroup": [
        <xsl:for-each select="RetailItemTechnicalInformationGroupList/RetailItemTechnicalInformationGroup">
        {
          "TechnicalInformationHeadingNo":"<xsl:value-of select="TechnicalInformationHeadingNo"/>", 
          "TechnicalInformationHeadingText":"<xsl:value-of select="TechnicalInformationHeadingText"/>",
          "RetailItemTechnicalInformationList":{
            "RetailItemTechnicalInformation": [
              <xsl:for-each select="RetailItemTechnicalInformationList/RetailItemTechnicalInformation">
              {
                "TechnicalInformationNo":"<xsl:value-of select="TechnicalInformationNo"/>",
                "TechnicalInformationRangeNo":"<xsl:value-of select="TechnicalInformationRangeNo"/>",
                "TechnicalInformationLegal":"<xsl:value-of select="TechnicalInformationLegal"/>",
                "TechnicalInformationText":"<xsl:value-of select="TechnicalInformationText"/>",
                "TechnicalInformationSeq":"<xsl:value-of select="TechnicalInformationSeq"/>",
                "TechnicalInformationExplanatoryText":"<xsl:value-of select="TechnicalInformationExplanatoryText"/>",
                "TechnicalInformationValueMetric":"<xsl:value-of select="TechnicalInformationValueMetric"/>",
                "TechnicalInformationUnitMetric":"<xsl:value-of select="TechnicalInformationUnitMetric"/>",
                "TechnicalInformationTextMetric":"<xsl:value-of select="TechnicalInformationTextMetric"/>",
                "TechnicalInformationValueImperial":"<xsl:value-of select="TechnicalInformationValueImperial"/>",
                "TechnicalInformationUnitImperial":"<xsl:value-of select="TechnicalInformationUnitImperial"/>",
                "TechnicalInformationTextImperial":"<xsl:value-of select="TechnicalInformationTextImperial"/>"
              }
    	        <xsl:if test="position() != last()">,</xsl:if>		
              </xsl:for-each>
            ]
          }
         }
		  	<xsl:if test="position() != last()">,</xsl:if>		
	  	</xsl:for-each>
      ]
    },
   
		"CatalogRefList":{
		"CatalogRef": [
		<xsl:for-each select="CatalogRefList/CatalogRef">
		{
		"Catalog": {
		"CatalogId": "<xsl:value-of select="Catalog/CatalogId"/>",
		"CatalogName": "<xsl:value-of select="Catalog/CatalogName"/>",
		"CatalogUrl": "<xsl:value-of select="Catalog/CatalogUrl"/>"
		},		
	<!-- 	"CatalogElementList": {
		"CatalogElement": {
		"CatalogElementId": "<xsl:value-of select="CatalogElementList/CatalogElement/CatalogElementId"/>",
		"CatalogElementName": "<xsl:value-of select="CatalogElementList/CatalogElement/CatalogElementName"/>",
		"CatalogElementType": "<xsl:value-of select="CatalogElementList/CatalogElement/CatalogElementType"/>",
		"CatalogElementUrl": "<xsl:value-of select="CatalogElementList/CatalogElement/CatalogElementUrl"/>"
		}
		} -->
			"CatalogElementList":{
						"CatalogElement": [
				<xsl:for-each select="CatalogElementList/CatalogElement">
				{
				
							"CatalogElementId": "<xsl:value-of select="CatalogElementId" />",
							"CatalogElementType": "<xsl:value-of select="CatalogElementType" />",
							"CatalogElementName": "<xsl:value-of select="CatalogElementName" />",
							"CatalogElementUrl": "<xsl:value-of select="CatalogElementUrl" />"
						}<xsl:if test="position() != last()">,</xsl:if>		
			</xsl:for-each>
			]}
		}
		<xsl:if test="position() != last()">,</xsl:if>		
		</xsl:for-each>
		]
		},
		
		"PriceUnitTextMetricEn": "<xsl:value-of select="PriceUnitTextMetricEn" />",
		"PriceUnitTextImperialEn": "<xsl:value-of select="PriceUnitTextImperialEn" />",
		 <xsl:if test="ItemType = 'ART'">
          "RetailItemCommAttachmentList":{
            "RetailItemCommAttachment": [
              <xsl:for-each select="RetailItemCommAttachmentList/RetailItemCommAttachment">
              {
                "AttachmentType":"<xsl:value-of select="AttachmentType"/>",
                "AttachmentUrl":"<xsl:value-of select="AttachmentUrl"/>",
                "SortNo":"<xsl:value-of select="SortNo"/>"
              }
    	        <xsl:if test="position() != last()">,</xsl:if>		
              </xsl:for-each>
            ]
          },
          
         
          </xsl:if>
        	"DemandList":{
		"Demand": [
		<xsl:for-each select="DemandList">
		{
		"Demand": "<xsl:value-of select="Demand"/>"
		}
		<xsl:if test="position() != last()">,</xsl:if>		
		</xsl:for-each>
		]
		},
        
		"RetailItemImageList":{
		"RetailItemImage": [
		<xsl:for-each select="RetailItemImageList/RetailItemImage">
		{
		"ImageHeight": "<xsl:value-of select="ImageHeight"/>",
		"ImageSize": "<xsl:value-of select="ImageSize"/>",
		"ImageType": "<xsl:value-of select="ImageType"/>",
		"ImageUrl": "<xsl:value-of select="ImageUrl"/>",
		"ImageUsage": "<xsl:value-of select="ImageUsage"/>",
		"ImageWidth": "<xsl:value-of select="ImageWidth"/>",
		"SortNo": "<xsl:value-of select="SortNo"/>"
		}
		<xsl:if test="position() != last()">,</xsl:if>		
		</xsl:for-each>
		]
		}
		}
	</xsl:template>

</xsl:stylesheet>
