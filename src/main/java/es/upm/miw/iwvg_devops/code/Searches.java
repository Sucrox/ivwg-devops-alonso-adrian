package es.upm.miw.iwvg_devops.code;

import java.util.stream.Stream;

public class Searches {

    public Stream<String> findUserNameBySomeImproperFraction(){
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .filter(Fraction::isImproper)
                        .count() > 1)
                .map(User::getName);
    }
    public Stream<String> findUserIdBySomeProperFraction(){
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .filter(Fraction::isProper)
                        .count() > 1)
                .map(User::getId);
    }

}
