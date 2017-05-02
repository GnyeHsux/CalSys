/*getMyBusiList*/
SELECT bi.*,ci.cust_name AS custName,di.item_name AS busiStatus FROM bussiness_info bi
LEFT JOIN apply_info ai ON ai.apply_id = bi.apply_id
LEFT JOIN cust_info ci ON ci.cust_id = ai.cust_id
LEFT JOIN dictionary_item di ON di.item_code = bi.`status`
WHERE di.dict_code = 'busi_status'