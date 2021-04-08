# RandomPasswordGenerator
A random password generator including 4 components: Number, Uppercase letters, Lowercase letters and Symbols.

The issue is that the algorithm throws random numbers to determine how many times the selected components occur in the password. It's completely fine but what if when the
random number is equal to 0 or it's same as the password's length ? Then some of the components may not appear in the password.

In order to solve this problem ( I've assumed that it is a problem ) the upper bound of the random number generator is automatically decremented by the number of remaining
components so that it is guranteed that the each component occur in the password at least once.
