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
    public Double findFirstDecimalFractionByUserName(String name){
        return new UsersDatabase().findAll()
                .filter(user -> name.equals(user.getName()))
                .flatMap(user -> user.getFractions().stream())
                .findFirst()
                .map(Fraction::decimal)
                .orElse(null);
    }

}
