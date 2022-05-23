package company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ATMServiceTest {
    private Bank bank;
    private BankAccount bankAccount;
    private BankDatabase bankDatabase;

    BankAccount acc1 = new BankAccount(0001, 1234, false, 10000.00, "Nordea", false);

    @BeforeEach
    void setup() {
        // bankAccount = mock(BankAccount.class);
        bankDatabase = mock(BankDatabase.class);
        bank = new Bank(bankDatabase);
    }

    @Test
    void should_ShowBalance_when_CheckBalance() {
        when(bankDatabase.getAccountByID(0001)).thenReturn(acc1);

        double expected = 10000.00;
        double actual = bank.checkBalance(0001);

        assertEquals(expected, actual);
    }

    @Test
    void should_Return9990_when_Withdraw10() {
        when(bankDatabase.getAccountByID(0001)).thenReturn(acc1);

        bank.withdrawAmount(0001, 10.00);

        double expected = 9990.00;
        double actual = bank.checkBalance(0001);

        assertEquals(expected, actual);
    }

    @Test
    void should_Return11000_when_Add1000() {
        when(bankDatabase.getAccountByID(0001)).thenReturn(acc1);

        bank.executeLogin(0001, 1234);

        bank.addAmount(0001, 1000.00);

        double expected = 11000.00;
        double actual = bank.checkBalance(0001);

        assertEquals(expected, actual);
    }

    @Test
    void should_isLoggedInBecomeTrue_when_CorrectPin() {
        when(bankDatabase.getAccountByID(0001)).thenReturn(acc1);

        bank.executeLogin(0001, 1234);

        assertTrue(acc1.isLoggedIn());
    }

    @Test
    void should_isLockedBecomeTrue_when_WrongPin3Tries() {
        when(bankDatabase.getAccountByID(0001)).thenReturn(acc1);

        bank.executeLogin(0001, 1155);
        bank.executeLogin(0001, 1255);
        bank.executeLogin(0001, 1666);
        bank.executeLogin(0001, 1666);

        assertTrue(acc1.isLocked());
    }

    @Test
    void should_ReturnNameOfBank(){
        try {
            MockedStatic<Bank> mockedStaticConverter = mockStatic(Bank.class);

            mockedStaticConverter.when(() -> bankAccount.bankName()).thenReturn("Nordea");

            String expected = "Nordea";
            String actual = bankAccount.bankName();

            assertEquals(expected, actual);

            System.out.println(bankAccount.bankName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}