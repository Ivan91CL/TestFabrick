INSERT INTO TRANSACTION_TYPES
SELECT 'GBS_TRANSACTION_TYPE', 'GBS_ACCOUNT_TRANSACTION_TYPE_0050'
WHERE
NOT EXISTS (
    SELECT ENUMERATION FROM TRANSACTION_TYPES WHERE ENUMERATION = 'GBS_TRANSACTION_TYPE'
);