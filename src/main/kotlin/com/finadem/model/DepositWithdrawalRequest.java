package com.finadem.model;

import com.finadem.enums.CurrencyEnum;
import com.finadem.enums.TransactionSource;
import com.finadem.enums.TransactionType;
import com.finadem.validations.AcceptedCurrency;
import com.finadem.validations.ValidIban;
import com.finadem.validations.ValidTransactionSource;
import com.finadem.validations.ValidTransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepositWithdrawalRequest {

    @NotBlank(message = "IBAN cannot be blank.")
    @ValidIban
    private String iban;

    @NotBlank(message = "Amount cannot be blank.")
    @Positive(message = "Amount must be a positive number.")
    private String amount;

    @NotNull(message = "Currency cannot be null.")
    @AcceptedCurrency
    private CurrencyEnum currency;

    @NotNull(message = "Transaction type cannot be null.")
    @ValidTransactionType
    private TransactionType transactionType;

    @Size(max = 255, message = "Transaction remarks cannot exceed 255 characters.")
    private String transactionRemarks;

    @NotNull(message = "Transaction source cannot be null.")
    @ValidTransactionSource
    private TransactionSource transactionSource;
}