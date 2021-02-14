package fr.esgi.gameoflife.core;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameOfLifeTest {

    private static final boolean DEAD = false;
    private static final boolean LIVE = true;

    @Nested
    class InterfaceContractTest {

        @Test
        void should_create_a_game_of_life_instance() {
            final var anInitialState = given_an_initial_state();

            final var theGameOfLife = new GameOfLife(anInitialState);

            assertThat(theGameOfLife).isNotNull();
        }

        @Test
        void should_fetch_the_next_state_after_a_tick() {
            final var anInitialState = given_an_initial_state();

            final var theNextState = new GameOfLife(anInitialState).tick();

            assertThat(theNextState).isInstanceOf(boolean[][].class);
        }

        private boolean[][] given_an_initial_state() {
            return grid(
                    row(DEAD, DEAD, DEAD),
                    row(LIVE, LIVE, LIVE),
                    row(DEAD, DEAD, DEAD)
            );
        }
    }

    private boolean[][] grid(final boolean[]... grid) {
        return grid;
    }

    private boolean[] row(final boolean... row) {
        return row;
    }
}