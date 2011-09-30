#Diffujion

Diffujion is a [diffusion-limited aggregation](http://en.wikipedia.org/wiki/Diffusion-limited_aggregation) 
simulator written in Java in my spare time. It is a hobby project with the following goals:

- Generation of organic-like clusters by means of simulated DLA
- Application of the [Strategy pattern](http://en.wikipedia.org/wiki/Strategy_pattern) throughout the simulation
- Simple enough that I could port it to Scala when I get the chance

##TODO

- Add strategy for Particle escape / particle death
- Add interactive mode, where you can see the simulation at each iteration
- Change implementation of Cluster so that it is not Array-based, so it can grow forever
