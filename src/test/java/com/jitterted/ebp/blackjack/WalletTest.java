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


}



