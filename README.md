# Image-Bleed-Edge-Creator
The application extrudes sprite and tile sheets to an edge. This is done to solve for a common rendering problem called 'Bleed over'. 

# How to use
The program is designed for command line at the moment. This is done so batch processing of files can be completed.

## Option 1
Run the jar with 2 arguments
* Argument 1: Input file path
* Argument 2: Size of sprites/tile slots

Example1: java -jar Image-Bleed-Edge-Creator-1.0.jar image.png 16

## Option 2
Run the jar with 4 arguments
* Argument 1: Input file path
* Argument 2: Output file path
* Argument 3: Size of sprites/tile slots
* Argument 4: Spacing to use around each tile

Example2: java -jar Image-Bleed-Edge-Creator-1.0.jar /input/image.png /output/image.png 16 2  

# FAQ

## Why use?
Quick solution to the problem while ensuring artists do not need to work harder.

## How does it work?
The application copies the tiles from the original image to a new image. Then uses the data to extrude the pixels over to a new edge. Once completed the new image is saved and can be used in other programs.

## Edge Bleed?
This is a common problem with poorly setup rendering systems for tile maps. In some cases the problem can not be solved due to other issues. When the problem shows it creates lines in the rendered tile map. These lines happen due to the rendering setup borrowing edges from nearby tiles in the sprite sheet. To solve for this an extra edge can be added between the tiles.

## Why not just create blank edges?
This does not solve the problem. Instead of getting the bleed over edge effect you end up with a hole in the map visually. This can create the same loss of immersion in renders and games.

## Is there a better way?
Yes, though not all solutions are perfect. Some options involve setting up the camera and render settings just right. Others involve messing with shaders and the render code itself. These options can be found by searching online for the given render or game engine being used.

# Warranty
THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS “AS IS” AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.