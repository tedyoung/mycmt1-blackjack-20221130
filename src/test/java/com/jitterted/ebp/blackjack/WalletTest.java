package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WalletTest {

    @Test
    void newWalletIsEmpty() {
        Wallet wallet = new Wallet();

        assertThat(wallet.isEmpty())
                .isTrue();
    }

    @Test
    void newWalletWhenAddMoneyThenIsNotEmpty() {
        Wallet wallet = new Wallet();

        wallet.addMoney(1);

        assertThat(wallet.isEmpty())
                .isFalse();
    }

    @Test
    void newWalletBalanceIsZero() {
        Wallet wallet = new Wallet();

        assertThat(wallet.balance())
                .isZero();
    }

    @Test
    void newWalletAdd10ThenBalanceIs10() throws Exception {
        Wallet wallet = new Wallet();

        wallet.addMoney(10); // COMMAND

        // QUERY: verify
        assertThat(wallet.balance())
                .isEqualTo(10);
    }

    @Test
    void newWalletAdd7AndAdd8ThenBalanceIs15() throws Exception {
        Wallet wallet = new Wallet();

        wallet.addMoney(7);
        wallet.addMoney(8);

        assertThat(wallet.balance())
                .isEqualTo(7 + 8);
    }

    @Test
    void addNegativeMoneyThrowsException() {
        Wallet wallet = new Wallet();

        assertThatThrownBy(() -> {
            wallet.addMoney(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void addZeroMoneyThrowsException() {
        Wallet wallet = new Wallet();

        assertThatThrownBy(() -> {
            wallet.addMoney(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}



