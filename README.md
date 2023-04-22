# Gwen't

First I designed generic tests for *Player* and *Cards* defining common and edge cases for every variable and method I
was planning on create to replicate the requested card game, for this purpose I used the testing framework **MUnit** in
my testing files and later on importing the package **Equals** to import it in every class to override some methods
useful for testing (**canEqual**, **equals** and **hashCode**).

The tests for *Player* include testing every **Equals** related methods I implemented and check the following: has a name,
initially has 2 gems, a *deck* of 25 cards and an empty hand, the *Player* can lose gems, decrease its amount of cards,
draw cards, a restriction of not be able to draw cards if the hand is full and the hand doesn't have more than 10 cards,
and finally the *Player* can shuffle its *deck*.

The tests for *Cards* varies between which ones are in testing, for every class it tests every **Equals** related method,
for **NonUnitCard** it checks if it has a name and its value of strength is equal to 0, for **UnitCard** additionally to
the previously mentioned tests it also checks the following: it has a value of *strength* greater than 0 and if it can
add 1, duplicate, set to 1 and reset its *strength* to its original value.

Now with the implementation of classes and methods itself I first created an abstract class **AbstractCard** to define
the minimum requirements of a card which are the parameters *name* and *strength*, then I created its getter and setter
methods in order for this to work in the classes that extends this abstract class.

Later I defined 2 interfaces, **Card** and **StrengthCapable**, the first one define the parameters previously mentioned
while the second one defines 4 different methods that are unique to cards that can use its *strength* in game;
**addStrength** it adds 1 to the actual *strength* of the card; **dupStrength** duplicates the *strength* of the card;
**lowStrength** sets to 1 the *strength* of the card; **resetStrength** sets the *strength* of the card to its original
value, useful when the card changed its *strength* during the game.

After that I defined 2 main classes, **UnitCard** and **NonUnitCard**, the first one is for cards that can use its
*strength* in game, and because of that it extends the trait **StrengthCapable**, unlike the other trait that's just
for weather cards, since they do not use their *strength* parameter in game.

The rest of classes are subclasses of **UnitCard** and **NonUnitCard**, for the first one I created 3 subclasses:
**MeleeCard**, **RangerCard** and **SiegeCard**; and the second one only has **WeatherCard** as a subclass, this with
the purpose of in the future making a difference between cards with different classifications when I implement the
table of the game.

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of the
[_Gwent_](https://www.playgwent.com/en)card game developed by [_CD PROJEKT RED_](https://cdprojektred.com/en/)

---

**The rest of the documentation is left for the users of this template to complete**