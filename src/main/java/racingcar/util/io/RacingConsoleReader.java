package racingcar.util.io;

import camp.nextstep.edu.missionutils.Console;

public class RacingConsoleReader implements ConsoleReader {

    @Override
    public String readLine() {
        return Console.readLine();
    }

    @Override
    public void close() {
        Console.close();
    }
}