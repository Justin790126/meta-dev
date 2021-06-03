# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "git://github.com/Justin790126/meta-ros-hello;protocol=https"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "a0aebf44e90bae470805012c6e68b26e38d6e335"

S = "${WORKDIR}/git"

# NOTE: unable to map the following CMake package dependencies: catkin
inherit ros_distro_melodic
inherit ros_superflore_generated

ROS_CN = "ros_tutorials"
ROS_BPN = "roscpp_tutorials"


ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_BUILD_DEPENDS = " \
    message-generation \
    roscpp \
    rospy \
    std-msgs \
"


ROS_EXPORT_DEPENDS = " \
    message-runtime \
    roscpp \
    rospy \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    message-runtime \
    roscpp \
    rospy \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""


