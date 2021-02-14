package fr.esgi.gameoflife.core.features;

import fr.esgi.gameoflife.core.GameOfLife;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.stream.Collectors;

public class Steps {

    GameOfLife gameOfLife;

    @Given("the following grid")
    public void the_following_grid(DataTable dataTable){


        List<List<Boolean>> test = dataTable.cells().stream().map(row -> row.stream().map(fields -> fields.equals("X")).collect(Collectors.toList())).collect(Collectors.toList());
        boolean[][] grid = new boolean[test.size()][test.size()];

        for(int x = 0; x < test.size() ; x++){
            for(int y = 0 ; y < test.get(x).size() ; y++){
                boolean val = test.get(x).get(y);
                grid[x][y] = val;
            }
        }
        this.gameOfLife = new GameOfLife(grid);

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if(grid[x][y]){
                    System.out.print('X');
                }else{
                    System.out.print('/');
                }
            }
            System.out.println();
        }
    }

    @When("player start next generation")
    public void player_triggers_next_generation() {
        this.gameOfLife.tick();
    }

    @Then("cell in center should be {string}")
    public void central_cell_should_be(String status) {
        boolean check = false;
        if(status.equals("X")){
            check = true;
        }

        int central = this.gameOfLife.getGrid().length / 2;
        boolean[][] grid = this.gameOfLife.getGrid();
        Assertions.assertThat(grid[central][central] == check);
    }





}
