# Gwen't
## Tarea 1

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

## Tarea 2

The UML diagram was created previously.

Before everything else I made the corrections according to the given feedback:
- Fixed the gem counter, so it can't get to negative values.
- Made an abstract class for the unit cards aside from the weather cards.
- Organized the code with packages.
- Fixed the implementation of the deck shuffle.
- Deleted the documentation of the methods equals and hashCode

After this I started implementing the new things that were required for this submission, starting for the new tests
involving the *Board* and its areas, added tests for *Player* involving playing cards of its hand and the **Equals**
related tests.

For the *Board* I only created a test involving the weather cards (for this I created a class *WeatherArea* that extends
*AbstractArea*) since the areas are managed by the players themselves, and to accomplish a possible implementation of the
game I created the class *PlayerBoard* that represents the areas of each player which in turn are classes that extend the
abstract class *AbstractArea* that extends the interface *Area* (for all of these classes I just tested the **Equals**
related methods since they don't have any other method and are just for organization of the project).

As for the implementation of the classes starting with *Board* I first designed it so in its parameters receives the 2
players that are going to be playing the game, and also the weather area since its common for both players, then for
*PlayerBoard* I create an instance of each area (melee, ranger and siege) for the *Player*, finally for the areas I
created the trait *Area* so every area has a list of cards and can add cards, then *AbstractArea* extends this interface
and defines the getter for the list of the area and the method **addCard** so *MeleeArea*, *RangerArea*, *SiegeArea* and
*WeatherArea* extends this abstract class (*WeatherArea* actually overrides the method **addCard** since here there can
only be one card at a time instead of keep adding more and more like the other areas).

Because of these changes I had to make some adjustments to the code like in the card classes I added the method
**addCard** making use of **double dispatch**, so it is possible for any card to know where it has to be added, and also
in the *Player* class adding the method **playCard** that calls the method **addCard** of the chosen card when the player
wants to play it.

Lastly I declared the scope of some parameters and variables by setting a few of them **private**, I don't think I need
to set protected parameters or variables considering how I made the code and aside from mutable lists every **val** is
public since they can't mutate and there is no problem with the default getter, as for mutable lists that are in some
parameters I created their getters, so it returns a copy of the list that is inmutable.

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of the
[_Gwent_](https://www.playgwent.com/en)card game developed by [_CD PROJEKT RED_](https://cdprojektred.com/en/)

---

**The rest of the documentation is left for the users of this template to complete**