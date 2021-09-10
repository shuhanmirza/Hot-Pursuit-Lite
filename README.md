# Hot Pursuit Lite

## Preface
Dear Agent X,

Welcome to the City of Bexiqun. I know that you are wondering about my identity. Do not worry about that. I am neither an enemy nor a friend. You were abducted from the city of Dhaka during Operation OBONTI. I know everything about you, your family, and this operation.  However, you were abducted to save yourself from an ambush in Mirpur, Dhaka.

Now, you must run. They know that you are here in Bexiqun. You will find the key to the car in your pocket.

Best Wishes,  
Mr. 101

## GamePlay
This is a simple 2D infinite runner game. The player gets a score by avoiding other cars on the road. The player can drive the car to the Left or Right using the Left/Right arrow keys. The main objective is to overtake as many cars as you can.

![](gameplay.gif)

## Code
The project utilizes Java AWT (Abstract Window Toolkit) API for generating GUI(Graphical User Interface).

### Structure
Launcher is the main class that instantiates an instance of Game class. The game instance starts a thread that 'ticks' and 'renders' State class objects. This project has 3 States:
- Menu
- Game
- Finish

The 'menu state' is shown at the start of execution. The 'game state' holds all the actions of this project. The 'finish state' shows the final score.

    ├── constants
    │   ├── Dimensions     <- constants that holds value of dimensions of UI elements
    │   ├── Numbers        <- integer constants
    │   ├── Positions      <- constants that holds value of positions of UI elements
    │   └── Strings        <- string constants
    │
    ├── entity              
    │   ├── Entity         <- Abstract parent class for game entities
    │   ├── Player         <- Player class for main character rendering and ticking
    │   ├── PublicCar      <- PublicCar class for challenger entity rendering and ticking
    │   └── PublicCarGenrationListener      <- triggers when a new car gets generated in UI
    │
    ├── gfx              
    │   ├── resources      <- contains every image resources
    │   ├── Assests        <- loads and delivers image for GUI
    │   ├── ImageLoader    <- helper class for importing image files
    │   └── SpriteSheet    <- crops spritesheet images into desirable sizes and shapes for extracting characters
    │
    ├── state              
    │   ├── State          <- Abstract parent class for game states
    │   ├── GameState      <- implements the rendering and the ticking of the main gameplay
    │   ├── MenuState      <- starting state
    │   └── FinishState    <- point showing state
    │
    ├── utils              <- hold utility codes
    │
    ├── Display            <- instantiates the GUI
    │
    ├── Game               <- renders and ticks the state classes in a thread
    │
    ├── KeyManager         <- reads user inputs
    │
    ├── Launcher           <- Main Class
    │

### Disclaimer
All the image resources are taken from the internet using google search. I did not produce any of the graphics assests.